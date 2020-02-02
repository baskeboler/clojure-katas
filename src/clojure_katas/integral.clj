(ns clojure-katas.integral
  (:require [clojure-katas.core :as core]))


(defn- abs [n]
  (if (neg? n)
    (* -1 n)
    n))

(core/defproblem integral
  "compute integral using Simpson's Rule,
  the integral of a function f between a and b is approximated as:
  h/3*[y_0 + 4y_1 + 2y_2 + 4y_3 + 2y_4 + ... + 2y_{n-2} + 4y_{n-1} + y_n],
  where h = (b - a)/n, for some even integer n, and y_{k} = f(a+kh)"
  [f a b n]
  (let [h  (double (/ (- b a) n))]
    (* (double (/ h 3)) 
       (+ (f  a)
          (f  b)
          (reduce + (map (comp (partial * 4 ) f ) (range  (+ a h)  (- b h) (* 2 h))))
          (reduce + (map (comp (partial * 2) f ) (range (+  a (* 2 h))  (- b (* 2 h)) (* 2 h))))))))