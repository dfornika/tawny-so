(ns tawny.obo.so
  (:require [tawny.read :as r]
            [tawny.owl :as o]
            [tawny.memorise :as m])
  (:refer-clojure :exclude [read double reverse]))

(def exclusions #{"http://purl.obolibrary.org/obo/SO_0000019"
                  "http://purl.obolibrary.org/obo/SO_0000358"
                  "http://purl.obolibrary.org/obo/SO_0000648"
                  "http://purl.obolibrary.org/obo/SO_0000649"
                  "http://purl.obolibrary.org/obo/SO_0000826"
                  "http://purl.obolibrary.org/obo/SO_0000827"
                  "http://purl.obolibrary.org/obo/SO_0000974"
                  "http://purl.obolibrary.org/obo/SO_0001065"
                  "http://purl.obolibrary.org/obo/SO_0001069"
                  "http://purl.obolibrary.org/obo/SO_0001242"
                  "http://purl.obolibrary.org/obo/SO_0001270"
                  "http://purl.obolibrary.org/obo/SO_0001430"
                  "http://purl.obolibrary.org/obo/SO_0001581"
                  "http://purl.obolibrary.org/obo/SO_0001584"
                  "http://purl.obolibrary.org/obo/SO_0001588"
                  "http://purl.obolibrary.org/obo/SO_0001625"
                  "http://purl.obolibrary.org/obo/SO_0001651"
                  "http://purl.obolibrary.org/obo/SO_0001652"
                  "http://purl.obolibrary.org/obo/SO_0001783"
                  "http://purl.obolibrary.org/obo/SO_0001900"
                  "http://purl.obolibrary.org/obo/SO_0001903"
                  "http://purl.obolibrary.org/obo/SO_0005839"
                  "http://purl.obolibrary.org/obo/SO_0002000"
                  "http://purl.obolibrary.org/obo/SO_0100042"
                  "http://purl.obolibrary.org/obo/SO_1000004"
                  "http://purl.obolibrary.org/obo/SO_1000007"
                  "http://purl.obolibrary.org/obo/SO_1000033"
                  "http://purl.obolibrary.org/obo/SO_1000034"
                  "http://purl.obolibrary.org/obo/SO_1000090"
                  "http://purl.obolibrary.org/obo/SO_1000091"
                  "http://purl.obolibrary.org/obo/SO_1000113"
                  "http://purl.obolibrary.org/obo/SO_1000114"
                  "http://purl.obolibrary.org/obo/SO_1000146"
                  "http://purl.obolibrary.org/obo/SO_1000177"
                  "http://purl.obolibrary.org/obo/SO_1000179"
                  "http://purl.obolibrary.org/obo/BS_00178"
                  "http://purl.obolibrary.org/obo/BS_00185"
                  "http://purl.obolibrary.org/obo/BS_00186"
                  "http://purl.obolibrary.org/obo/BS_00187"
                  "http://purl.obolibrary.org/obo/BS_00202"
                  "http://purl.obolibrary.org/obo/BS_00203"
                  "http://purl.obolibrary.org/obo/BS_00204"
                  "http://purl.obolibrary.org/obo/BS_00205"
                  "http://purl.obolibrary.org/obo/BS_00206"
                  "http://purl.obolibrary.org/obo/BS_00207"
                  "http://purl.obolibrary.org/obo/BS_00208"
                  "http://purl.obolibrary.org/obo/BS_00209"
                  "http://purl.obolibrary.org/obo/BS_00210"
                  "http://purl.obolibrary.org/obo/BS_00235"
                  })

(r/defread so
  :location (o/iri "https://raw.githubusercontent.com/The-Sequence-Ontology/SO-Ontologies/master/so.owl")
  :prefix "so:"
  :iri "http://purl.obolibrary.org/obo/so.owl"
  :viri "http://purl.obolibrary.org/obo/so/so-xp/releases/2015-11-24/so-xp.owl/so.owl"
  :transform r/label-transform
  :filter (fn [o e] (and (r/iri-starts-with-filter "http://purl.obolibrary.org/obo/SO" o e)
                         (not (contains? exclusions (.toStringID e))))))
