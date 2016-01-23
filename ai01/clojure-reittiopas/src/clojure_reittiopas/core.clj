(ns clojure-reittiopas.core
  (:use [clojure-reittiopas.json-reader :only [tram-graph]]
        [clojure-reittiopas.breadth-first-search :only [searh-route]]))

(defn -main
  "Search shortest route from node to node in verkko.json"
  [& args]
  (let [graph (tram-graph "resources/verkko.json")]
    (println (searh-route graph "1250429" "1121480"))))
