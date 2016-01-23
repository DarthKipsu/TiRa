(ns clojure-reittiopas.breadth-first-search
  (:use [clojure-reittiopas.tram-stops :only [id restv with-neighbours]]))

(defn- breadth-first [graph deque visited end]
  (let [node (id (:node (first deque)))
        route (:route (first deque))]
    (cond (contains? visited node) (recur graph (restv deque) visited end)
          (= node end) route
          :else (let [new-visited (conj visited node)]
                  (recur graph (with-neighbours deque graph new-visited) new-visited end)))))

(defn searh-route [graph start end]
  (let [start-stop (get graph start)
        end-stop (get graph end)
        deque [{:node start-stop :route [(id start-stop)]}]
        visited #{}]
    (breadth-first graph deque visited (id end-stop))))
