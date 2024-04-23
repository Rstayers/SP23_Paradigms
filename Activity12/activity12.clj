;; Q1 Declare a variable a that is a list with the numbers 13, 77, and 88
(def a [13 77 88])

;; Q2 Declare a variable called q2 whose value is the output of the expression 1+ 10 / 2
;; print the result to the console
(def q2 (+ 1 (/ 10 2)))
(println q2)

;; Q3 Define a function greet that takes no arguments and prints "Hello".
(defn greet [] (println "Hello"))

;; Q4 Define a function greeting which:
;; - Given no arguments, returns "Hello, World!"
;; - Given one argument x, returns "Hello, x!"
;; - Given two arguments x and y, returns "x, y!"
(defn greeting
  ([] "Hello, World!")
  ([x] (str "Hello, " x "!" ))
  ([x y] (str x ", " y "!")))

;; For testing your Q4 implementation
(assert (= "Hello, World!" (greeting)))
(assert (= "Hello, Clojure!" (greeting "Clojure")))
(assert (= "Good morning, Clojure!" (greeting "Good morning" "Clojure")))

