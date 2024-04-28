(defn square-sum [n]
  ;; Generate the range and map it to its squares
  (let [squares (map #(* % %) (range 1 (inc n)))]
    ;; Print each square on a new line
    (doseq [square squares]
      (println square))
    ;; Reduce the sequence to compute the sum
    (let [sum (reduce + 0 squares)]
      ;; Print the sum
      (println "Sum =" sum))))

;; Parse the command-line argument to an integer
(def n (Integer/parseInt (first *command-line-args*)))

;; Call the function with n
(square-sum n)
