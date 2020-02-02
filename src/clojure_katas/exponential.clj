(ns clojure-katas.exponential
  (:require [clojure-katas.core :as core]))

(core/defproblem expt-linear
   "b^n = b*b^(n-1)
   b^0 = 1"
   [base index]
   (if (zero? index) 1
       (apply * (repeat index base))))

(core/defproblem expt-fast
  "b^n = (b^(n/2))^2 if n is even
   b^n = b*b^(n-1) if n is odd"
  [base index]
  (let [square #(* % %)]
      (cond
        (zero? index) 1
        (even? index) (square (expt-fast base (int (/ index 2))))
        :else (* base (expt-fast base (dec index))))))
