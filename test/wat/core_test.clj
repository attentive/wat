(ns wat.core-test
  (:use clojure.test
        wat.core))

(def test-files ["test/weimarrepublic.mp3" "test/Beethoven - Fur Elise.mp3"])

(deftest read-test
  (testing "Reading :TRACK values from files."
    (is (= "Beethoven") (wat-val (read-audiofile "test/Beethoven - Fur Elise.mp3") :TRACK))))
