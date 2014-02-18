(ns wat.core-test
  (:use clojure.test
        wat.core))

(def test-files ["test/weimarrepublic.mp3" "test/Beethoven - Fur Elise.mp3"])

(deftest read-test
  (testing "Reading :TRACK values from files."
    (is (= "Beethoven") (wat-val (read-audiofile "test/Beethoven - Fur Elise.mp3") :TRACK))))

(deftest read-all-test
  (testing "Reading all wat-vals from a file."
    (is (= "Beethoven")
        (let [vals (wat-vals (read-audiofile "test/Beethoven - Fur Elise.mp3"))]
          (print vals) ; dump all the vals in the file to console
          (:TRACK vals)))))

(run-tests)
