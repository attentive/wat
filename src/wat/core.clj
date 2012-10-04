(ns wat.core
  (:import (org.jaudiotagger.audio AudioFileIO AudioFile)
           (org.jaudiotagger.tag FieldKey) 
           (java.io File)))

(def wat-keys
  "List the distinct valid keys available to query in the jaudiotagger unified format API." 
  (distinct (sort (map #(-> %1 .toString keyword) (FieldKey/values)))))

(defn wat-val [audiofile k]
  "Get the first value of a specific wat key found in a tag." 
  (-> audiofile .getTag (.getFirst (FieldKey/valueOf (name k))))) 

(defn read-audiofile [filename]
  "Read an audio file."
  (AudioFileIO/read (java.io.File. filename)))

