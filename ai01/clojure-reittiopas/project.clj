(defproject clojure-reittiopas "0.1.0-SNAPSHOT"
  :description "Reittiopas breadth first search"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/data.json "0.2.6"]]
  :main ^:skip-aot clojure-reittiopas.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
