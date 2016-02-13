(ns progen.core
  (:gen-class))

(defn- gen-top [prob]
  (if (< (rand) prob) 1 0))

(defn- gen-middle [prob & conditions]
  (if (every? #{1} conditions) (gen-top prob) 0))

(defn- sample
  ([i] (sample))
  ([]
   (let [A (gen-top 0.9)
         B (gen-top 0.95)
         R (gen-middle 0.9 A)
         S (gen-middle 0.95 A)
         K (gen-middle 0.99 S B)
         L (gen-middle 0.99 K)]
     {:a A :b B :r R :s S :k K :l L})))

(defn- R-B-no-K? [s]
  (and (= 1 (:r s)) (= 1 (:b s)) (= 0 (:k s))))

(defn- R-S-B? [s]
  (and (= 1 (:r s)) (= 1 (:s s)) (= 1 (:b s))))

(defn- no-R-S-B? [s]
  (and (= 0 (:r s)) (= 1 (:s s)) (= 1 (:b s))))

(defn- K? [s]
  (= 1 (:k s)))

(defn- A? [s]
  (= 1 (:a s)))

(defn -main [& args]
  (let [samples (map sample (range 100000))
        RBnoK (filter R-B-no-K? samples)
        RSB (filter R-S-B? samples)
        noRSB (filter no-R-S-B? samples)]
    (println "RBnoK:" (count RBnoK) (count (filter A? RBnoK)))
    (println "RSB:" (count RSB) (count (filter K? RSB)))
    (println "noRSB:" (count noRSB) (count (filter K? noRSB)))))
