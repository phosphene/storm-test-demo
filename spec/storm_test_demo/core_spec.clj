(ns storm-test-demo.core-spec
  (:import [backtype.storm StormSubmitter LocalCluster])
  (:use [backtype.storm clojure config])
  (:require [speclj.core :refer :all]
            [storm-test-demo.core :refer :all]
            ))


(defn run-local! []
  (let [cluster (LocalCluster.)]
    (.submitTopology cluster "word-count" {TOPOLOGY-DEBUG true} (mk-topology))
    (Thread/sleep 10000)
    (.shutdown cluster)
    ))

(defn submit-topology! [name]
  (StormSubmitter/submitTopology
   name
   {TOPOLOGY-DEBUG true
    TOPOLOGY-WORKERS 3}
   (mk-topology)))

(defn submit-and-run-topo
  ([]
   (run-local!))
  ([name]
   (submit-topology! name)))




(describe "Demonstrate Storm"
  (before-all
    (println "Start testing")
    (submit-and-run-topo)

)
  
  (after-all
    (println "Finished testing"))
    
  (before
    (println "Before each test"))
    
  (after
    (println "After each test"))

)

(run-specs)
