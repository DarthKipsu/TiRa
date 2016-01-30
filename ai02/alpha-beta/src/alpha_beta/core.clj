(ns alpha-beta.core
  (:gen-class))

(def prefilled-grid [:o :x :o :x nil :x nil :o nil])

(def empty-grid (apply vector (take 9 (repeat nil))))

(defn- line-of-three? [x y z]
  (if (and (not-any? nil? [x y z]) (= x y z)) x))

(defn- full? [grid]
  (if (not-any? nil? grid) :tie))

(defn- end-state? [grid]
  (let [a1 (get grid 0) a2 (get grid 1) a3 (get grid 2)
        b1 (get grid 3) b2 (get grid 4) b3 (get grid 5)
        c1 (get grid 6) c2 (get grid 7) c3 (get grid 8)]
    (some identity
          [(line-of-three? a1 a2 a3)
           (line-of-three? b1 b2 b3)
           (line-of-three? c1 c2 c3)
           (line-of-three? a1 b1 c1)
           (line-of-three? a2 b2 c2)
           (line-of-three? a3 b3 c3)
           (line-of-three? a1 b2 c3)
           (line-of-three? a3 b2 c1)
           (full? grid)])))

(defn- value [outcome]
  (cond (= :o outcome) 1
        (= :x outcome) -1
        (= :tie outcome) 0))

(defn- winner [outcome]
  (cond (= 1 outcome) "O"
        (= -1 outcome) "X"
        :else "tie"))

(defn- try-move [grid sign square]
  (assoc grid square sign))

(defn- next-grids
  ([grid sign] (next-grids grid sign '() 0))
  ([grid sign kids square]
   (cond (= 9 square) kids
         (not (nil? (get grid square))) (recur grid sign kids (inc square))
         :else (recur grid sign (conj kids (try-move grid sign square)) (inc square)))))

(declare min-value)

(defn- max-value 
  ([grid, alpha, beta]
   (let [end (end-state? grid)]
     (if end (value end)
       (max-value (next-grids grid :x) alpha beta Integer/MIN_VALUE))))
  ([grids alpha beta v]
   (let [new-v (max v (min-value (first grids) alpha beta))]
     (cond (>= new-v beta) new-v
           (empty? (rest grids)) new-v
           :else (recur (rest grids) (max new-v alpha) beta new-v)))))

(defn- min-value 
  ([grid, alpha, beta]
   (let [end (end-state? grid)]
     (if end (value end)
       (min-value (next-grids grid :o) alpha beta Integer/MAX_VALUE))))
  ([grids alpha beta v]
   (let [new-v (min v (max-value (first grids) alpha beta))]
     (cond (<= new-v alpha) new-v
           (empty? (rest grids)) new-v
           :else (recur (rest grids) alpha (min new-v beta) new-v)))))

(defn alpha-beta-value [grid]
  (min-value grid -1 1))

(defn -main [& args]
  (println "Winner with prefilled game:" (winner (alpha-beta-value prefilled-grid)))
  (println "Winner with empty grid:" (winner (alpha-beta-value empty-grid))))
