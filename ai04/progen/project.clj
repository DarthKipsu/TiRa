(defproject progen "0.1.0-SNAPSHOT"
  :description "Probability generator"
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :main ^:skip-aot progen.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
