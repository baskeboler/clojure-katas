(ns clojure-katas.pascal-triangle
  (:require [clojure-katas.core :as core]))


(defn pascal1 [row col]
  (cond
    (or (zero? row)
        (zero? col)
        (= row col)) 1
    :else (long 
           (+ (pascal1 (dec row) (dec col))
              (pascal1 (dec row) col)))))

(core/defproblem compute
  "Use tree recursion to solve pascal triangle,
   it builds up a tree of vars and uneccesarily
   builds up a stack in memory, highly ineffective"
  [row col]
  (pascal1 row col))

(defn- pascal-row-mults [row]
  (for [n (range 1 (inc row))] 
    (/ (- (inc row) n)
       n)))

(defn- pascal-row [row]
  (loop [res [1]
         factors (pascal-row-mults row)]
    (if (empty? factors)
      res
      (recur (conj res (* (last res) 
                          (first factors)))
             (rest factors)))))

(core/defproblem compute-alt
  "Use iterative recursion to solve pascal triangle,
  computes out the triangle as we go,
    if row found -> return row[col]
    else computes the vals of the current row
  stop building
  and return the current iterating value for requested
  position."
  [row col]
  (cond 
    (or (zero? row)
        (zero? col)) 1
    :else (->> (pascal-row row)
               (drop col)
               first)))
         

