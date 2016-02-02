(ns spam-ham.core
  (:gen-class)
  (:require [clojure.string :as str])
  (:use [clojure.java.io :only [reader]] :reload))

(defn- to-map [divisor a-map line]
  (let [item (str/split (str/trim line) #" ")]
    (assoc a-map (second item) (/ (Integer/parseInt (first item)) divisor))))

(defn- read-word-counts [file divisor]
  (with-open[rdr (reader file)]
    (reduce (partial to-map divisor) {} (line-seq rdr))))


(defn -main
  "Count how likely a message is spam based on spam and ham message word frequencies."
  [& args]
  (let [spam (read-word-counts "resources/spamcount.txt" 75268)
        ham (read-word-counts "resources/hamcount.txt" 290673)]
    (println (count spam)  (count ham))))
