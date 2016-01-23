(ns clojure-reittiopas.tram-stops)

(defn stop-id [stop]
  (get stop "koodi"))

(defn- conj-node [graph route visited deque stop]
  (let [stop-node (get graph (first stop))]
    (if (contains? visited (get stop-node "koodi")) deque
      (conj deque {:node stop-node :route (conj route (stop-id stop-node))}))))

(defn with-neighbours [deque graph visited]
  (let [stop (:node (first deque))
        neighbours (get stop "naapurit")
        conj-node-pre (partial conj-node graph (:route (first deque)) visited)]
    (vec (rest (reduce conj-node-pre deque neighbours)))))
