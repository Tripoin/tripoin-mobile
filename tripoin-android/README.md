# tripoin-android
Repository For Android Apps

Development Guide 
==================
1. Code convention
	- Interface harus diawali dengan prefix I. contoh IGenericDAO
	- Abstract class harus diawali dengan prefix A. contoh AGenericDAO
	- Package untuk class - class implementasi harus berada dalam subclass dari package interface, dengan nama impl
2. tripoin-common
    - component : Interface yang digunakan untuk melakukan proses dalam sebuah class yang mengimplementasi. Class implementasi nantinya diharuskan men-set parameter input, parameter output. override  method process untuk detail masing- masing proses di class implementasinya.
3. 