(ns clojure-reittiopas.core
  (:use [clojure-reittiopas.json-reader :only [tram-graph]]
        [clojure-reittiopas.breadth-first-search :only [searh-route]]
        [clojure-reittiopas.tram-stops :only [id stop-name]]))

(defn- has-more [stops]
  (> (count stops) 1))

(defn- print-stops [stops graph]
  (let [stop (get graph (first stops))]
    (println (id stop) (str "(" (stop-name stop) ")"))
    (if (has-more stops) (recur (rest stops) graph))))

(defn -main
  "Search shortest route from node to node in verkko.json"
  [& args]
  (let [graph (tram-graph "resources/verkko.json")]
    (print-stops (searh-route graph "1250429" "1121480") graph)))
