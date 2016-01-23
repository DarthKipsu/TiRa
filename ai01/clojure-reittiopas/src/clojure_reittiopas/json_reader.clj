(ns clojure-reittiopas.json-reader
  (:require [clojure.data.json :as json]))

(defn- add-stop [stops a-stop]
  (assoc stops (get a-stop "koodi") a-stop))

(defn- read-json [path]
  (json/read-str (slurp path)))

(defn tram-graph [path]
  (let [stops (read-json path)]
    (reduce add-stop {} stops)))

