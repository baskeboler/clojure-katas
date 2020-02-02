(ns clojure-katas.max-prime-factor
  (:require [clojure-katas.core :as core]))

(core/defproblem max-prime-factor
  "
   Base case:
    if number = div, return number
    if div > (number)^(1/2), return number (cover square case such as 4)
   Iterative case:
    if number can be divided by div, then decrement number by the factor of div, loop
    if number cannot be divided by div, then increment div by 1, loop"
  [number]
  (let [number-sqrt (long (Math/sqrt number))]
    (loop [n number 
           d 2]
      (cond 
        (= n d) n 
        (> d number-sqrt) n 
        :else (recur (if (zero? (rem n d)) 
                       (long (/ n d))
                       n)
                     (if-not (zero? (rem n d))
                       (inc d)
                       d))))))

