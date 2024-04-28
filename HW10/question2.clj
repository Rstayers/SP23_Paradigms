;; Define the taxation namespace with the tax function
(ns taxation)

(defn tax [amount rate]
  ;; Calculate tax and round the result to 4 decimal places
  (let [raw-tax (* amount (/ rate 100.0))]
    (format "%.4f" raw-tax)))

;; Switch to the application namespace to use the taxation functions
(ns application
  (:require [taxation :refer [tax]]))

(defn -main []
  (let [product-cost 117
        tax-rate 7
        computed-tax (tax product-cost tax-rate)]  ; Call the tax function which now handles rounding
    (println "The tax for the product is" computed-tax)))

(-main)

