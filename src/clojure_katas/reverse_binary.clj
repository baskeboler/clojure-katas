(ns clojure-katas.reverse-binary
  (:require [clojure-katas.core :as core]))


(defn ->bin [n]
  (reverse 
   (map #(rem % 2)
        (take-while 
         pos? 
         (iterate #(int (/ % 2)) n)))))

(defn bin->base10 [bitlist]
  (reduce (fn [res n]
            (+ (* res 2)
               n))
          bitlist))
(core/defproblem compute
  "Credit: Spotify Puzzle: http://labs.spotify.com/puzzles/
   Your task will be to write a program for reversing numbers in binary. 
   For instance, the binary representation of 13 is 1101, 
   and reversing it gives 1011, which corresponds to number 11.
  
   The input contains a single line with an integer N, 1 ≤ N ≤ 1000000000.
   The output one line with one integer, the number we get by reversing the binary representation of N.

   Sample input 1: 13
   Sample output 1: 11
   Sample input 2: 47
   Sample output 2: 61
   "
  [num]
  (bin->base10
   (reverse (->bin num))))

