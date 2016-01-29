(ns alpha-beta.core
  (:gen-class))

(def prefilled-grid [:o :x :o :x nil :x nil :o nil])
(def win-grid [:o :x :o :x :x :x nil :o nil])
(def full-grid [:o :x :o :o :x :x :x :o :o])

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

(defn -main [& args]
  (println empty-grid)
  (println prefilled-grid)
  (println (end-state? prefilled-grid) (end-state? win-grid) (end-state? full-grid))
  (println (value (end-state? win-grid)) (value (end-state? full-grid)))
  )
