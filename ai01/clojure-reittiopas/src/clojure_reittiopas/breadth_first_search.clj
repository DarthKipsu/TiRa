(ns clojure-reittiopas.breadth-first-search
  (:use [clojure-reittiopas.tram-stops :only [stop-id with-neighbours]]))

(defn- breadth-first [graph deque visited end]
  (let [current (:node (first deque))
        route (:route (first deque))]
    (Thread/sleep 100)
    (cond (contains? visited (stop-id current)) (recur graph (rest deque) visited end)
          (= (stop-id current) end) route
          :else (let [new-visited (conj visited (stop-id current))]
                  (recur graph (with-neighbours deque graph new-visited) new-visited end)))))

(defn searh-route [graph start end]
  (let [start-stop (get graph start)
        end-stop (get graph end)
        deque [{:node start-stop :route [(stop-id start-stop)]}]
        visited #{}]
    (breadth-first graph deque visited (get end-stop "koodi"))))
