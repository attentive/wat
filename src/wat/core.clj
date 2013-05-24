(ns wat.core
  (:import (org.jaudiotagger.audio AudioFileIO AudioFile)
           (org.jaudiotagger.tag FieldKey) 
           (java.io File)))

(def wat-keys
  "List the distinct valid field keys available to query in the jaudiotagger unified format API." 
  (set (sort (map #(-> %1 .toString keyword) (FieldKey/values)))))

(defn valid-wat-key [k]
  "Determine if a field key is valid."
  (contains? wat-keys k))

(defn wat-val [audiofile k]
  "Get the first value of a specific wat key found in a tag." 
  (-> audiofile .getTag (.getFirst (FieldKey/valueOf (name k))))) 

(defn wat-vals [audiofile]
  "List all wat keys and their vals in an audiofile."
  (into {} (for [k wat-keys] [k (wat-val audiofile k)])))

(defn read-audiofile [filename]
  "Read an audio file."
  (AudioFileIO/read (java.io.File. filename)))



