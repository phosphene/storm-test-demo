(defproject storm-test-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.slf4j/slf4j-api "1.7.1"] 
                 [org.slf4j/slf4j-simple "1.7.1"] 
                 [commons-collections/commons-collections "3.2.1"]
                 [commons-io "2.1"]
                 [joda-time "2.3"]
                 ]
  :main ^:skip-aot storm-test-demo.core
  :target-path "target/%s"
  :profiles {
             :dev
             {:dependencies [
                             [storm "0.9.0.1" :exclusions [commons-io org.slf4j/slf4j-api org.yaml/snakeyaml]]
                             [org.testng/testng "6.8.5"]
                             [org.easytesting/fest-assert-core "2.0M8"]
                             [org.mockito/mockito-all "1.9.0"]
                             [org.jmock/jmock "2.6.0"]
                             [midje "1.6.0" :exclusions [org.clojure/clojure joda-time]]
               
                             [speclj "2.5.0"]
                             [lein-midje "3.1.3"]]}
                             
             :uberjar {:aot :all}})

