(ns clojure-reittiopas.tram-stops)

(defn restv [a-vec]
  (vec (rest a-vec)))

(defn id [stop]
  (get stop "koodi"))

(defn stop-name [stop]
  (get stop "nimi"))

(defn- neighbours [stop]
  (get stop "naapurit"))

(defn- conj-node [graph route visited deque stop]
  (let [node (get graph (first stop))]
    (if (contains? visited (id node)) deque
      (conj deque {:node node :route (conj route (id node))}))))

(defn with-neighbours [deque graph visited]
  (let [stop (:node (first deque))
        neighbours (neighbours stop)
        node-neighbours (partial conj-node graph (:route (first deque)) visited)]
    (restv (reduce node-neighbours deque neighbours))))
