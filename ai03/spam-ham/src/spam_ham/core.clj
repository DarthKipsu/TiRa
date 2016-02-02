(ns spam-ham.core
  (:gen-class)
  (:require [clojure.string :as str])
  (:use [clojure.java.io :only [reader]] :reload))

(defn- to-map [divisor a-map line]
  (let [item (str/split (str/trim line) #" ")]
    (assoc a-map (second item) (/ (Integer/parseInt (first item)) divisor))))

(defn- conj-words [a-list line]
  (apply conj a-list (str/split (str/trim line) #" ")))

(defn- read-word-counts [file divisor]
  (with-open[rdr (reader file)]
    (reduce (partial to-map divisor) {} (line-seq rdr))))

(defn- mail-words [file]
  (let [lines (str/split-lines (slurp file))]
    (reduce conj-words '() lines)))

(defn- prob [p-list word]
  (let [p (get p-list word)]
    (if (nil? p) 1/100000
      p)))

(defn- prob-spam-ham [word spam ham]
  (Math/log (/ (prob spam word) (prob ham word))))

(defn- prob-with-word [spam ham probability word]
  (+ probability (prob-spam-ham word spam ham)))

(defn- likely-spam [file spam ham]
  (let [starting-prob (Math/log (/ 1/2 1/2))
        odds (reduce (partial prob-with-word spam ham) starting-prob (mail-words file))
        spam-amount (/ odds (+ 1 odds))]
    (if (< 1 spam-amount) (- spam-amount 1)
      spam-amount)))

(defn -main
  "Count how likely a message is spam based on spam and ham message word frequencies."
  [& args]
  (let [spam (read-word-counts "resources/spamcount.txt" 75268)
        ham (read-word-counts "resources/hamcount.txt" 290673)]
    (println (likely-spam (first args) spam ham))))
