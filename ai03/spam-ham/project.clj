(defproject spam-ham "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :main ^:skip-aot spam-ham.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
