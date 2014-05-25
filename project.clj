(defproject acey-ducey "0.1.0-SNAPSHOT"
  :description "Worst betting game ever"
  :url "http://github.com/acey-ducey"
  :license {:name "None"
            :url "/dev/null"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :main ^:skip-aot acey-ducey.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
