(defproject learningclojure "0.1.0-SNAPSHOT"
  :description "Clojure Learning Repository"
  :url "https://github.com/itsrainingmani/LearningClojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot learningclojure.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
