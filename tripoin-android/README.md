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
    - constant : Interface yang digunakan untuk constant variable dalam aplikasi. Karena android bersifat "configurable by database" maka dari itu constant lebih diarahkan ke dalam bentuk variable dalam interface. Jika diperlukan konfigurasi yang lebih dinamis, lebih baik menggunakan local database yang datanya diperolah dari REST.
        - Application Constant : Dispesifikasikan untuk constant kebutuhan aplikasi. ie : basic host, basic port. 
        - General Constant : Dispesifikasikan untuk kebutuhan constant secara umum. ie : punctuation, binary values.
    - dto : dto basic aplikasi. digunakan untuk bridging error message dari low level authentication ke high level application. ie : bridging error message dari validasi password menggunakan regex, etc. Setiap dto dalam aplikasi ini harus mengimplementasikan PARCELABLE interface. Karena arsitektur PARCELABLE memungkinkan transfer data yang 10 kali lebih cepat dari SERIALIZABLE. untuk mengimplementasi PARCELABLE, developer hanya perlu menambahkan anotasi "@Parcel" diatas nama class dto tsb.
    - error : interface untuk listener error low level ke high level. listener ini harus dikombinasikan dengan dto diatas.
3. 