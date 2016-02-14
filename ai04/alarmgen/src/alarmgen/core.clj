(ns alarmgen.core
  (:gen-class))

(defn- gen-top [prob]
  (if (< (rand) prob) 1 0))

(defn- gen-middle [cond-a cond-b]
  (cond (and (= 1 cond-a) (= 1 cond-b)) (gen-top 0.97)
        (= 1 cond-a) (gen-top 0.81)
        (= 1 cond-b) (gen-top 0.92)
        :else (gen-top 0.0095)))

(defn- sample
  ([i] (sample))
  ([]
   (let [earthquake (gen-top 0.009)
         robbery (gen-top 0.0032)
         alarm (gen-middle earthquake robbery)]
     {:earthquake earthquake :robbery robbery :alarm alarm})))

(defn- earthquake? [s]
  (= 1 (:earthquake s)))

(defn- robbery? [s]
  (= 1 (:robbery s)))

(defn- alarm? [s]
  (= 1 (:alarm s)))

(defn -main [& args]
  (let [samples (map sample (range 1000000))
        alarms (filter alarm? samples)
        alarm-and-robberies (filter robbery? alarms)
        alarm-and-earthquakes (filter earthquake? alarms)]
    (println "alarms:" (count alarms))
    (println "alarms with robberies:" (count alarm-and-robberies))
    (println "alarms and earthquakes:" (count alarm-and-earthquakes))
    (println "alarms, earthquakes and robberies:" (count (filter robbery? alarm-and-earthquakes)))))
