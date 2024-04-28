(ns temperature-analysis)

(defn f-to-c [f]
  "Convert Fahrenheit to Celsius."
  (* (/ 5 9) (- f 32)))

(defn parse-temperatures [file-path]
  "Parse temperatures from a file and convert them to a list of Celsius values."
  (let [file-contents (slurp file-path)
        temperatures (map #(f-to-c (Double/parseDouble %)) (clojure.string/split file-contents #"\n"))]
    temperatures))

(defn compute-stats [temperatures]
  "Compute minimum, maximum, and average of a list of temperatures."
  (let [min-temp (apply min temperatures)
        max-temp (apply max temperatures)
        avg-temp (/ (reduce + temperatures) (count temperatures))]
    {:min min-temp :max max-temp :avg avg-temp}))

(defn -main []
  "Main function to read file, convert temperatures, and print stats."
  (let [temperatures (parse-temperatures "temperatures.txt")
        stats (compute-stats temperatures)]
    (println "Minimum Temperature (C):" (:min stats))
    (println "Maximum Temperature (C):" (:max stats))
    (println "Average Temperature (C):" (:avg stats))))

(-main)

