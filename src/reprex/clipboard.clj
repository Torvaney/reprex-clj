(ns reprex.clipboard)

;; From: https://gist.github.com/Folcon/1167903


(defn get-clipboard []
  (.getSystemClipboard (java.awt.Toolkit/getDefaultToolkit)))


(defn slurp-clipboard []
  (try
    (.getTransferData (.getContents (get-clipboard) nil) (java.awt.datatransfer.DataFlavor/stringFlavor))
    (catch java.lang.NullPointerException e nil)))


(defn spit-clipboard [text]
  (.setContents (get-clipboard) (java.awt.datatransfer.StringSelection. text) nil))
