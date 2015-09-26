# tripoin-android
Repository For Android Apps

Development Guide 
==================
* Code convention
	- Interface harus diawali dengan prefix I. contoh IGenericDAO
	- Abstract class harus diawali dengan prefix A. contoh AGenericDAO
	- Package untuk class - class implementasi harus berada dalam subclass dari package interface, dengan nama impl
	- Setiap akronim nama class, harus diberi prefix Uppper Case, ie : DAOUser, DTOUser, etc	
* tripoin-common
    - component : Interface yang digunakan untuk melakukan proses dalam sebuah class yang mengimplementasi. Class implementasi nantinya diharuskan men-set parameter input, parameter output. override  method process untuk detail masing- masing proses di class implementasinya.
    - constant : Interface yang digunakan untuk constant variable dalam aplikasi. Karena android bersifat "configurable by database" maka dari itu constant lebih diarahkan ke dalam bentuk variable dalam interface. Jika diperlukan konfigurasi yang lebih dinamis, lebih baik menggunakan local database yang datanya diperolah dari REST.
        - Application Constant : Dispesifikasikan untuk constant kebutuhan aplikasi. ie : basic host, basic port. 
        - General Constant : Dispesifikasikan untuk kebutuhan constant secara umum. ie : punctuation, binary values.
    - dto : dto basic aplikasi. digunakan untuk bridging error message dari low level authentication ke high level application. ie : bridging error message dari validasi password menggunakan regex, etc. Setiap dto dalam aplikasi ini harus mengimplementasikan PARCELABLE interface. Karena arsitektur PARCELABLE memungkinkan transfer data yang 10 kali lebih cepat dari SERIALIZABLE. untuk mengimplementasi PARCELABLE, developer hanya perlu menambahkan anotasi "@Parcel" diatas nama class dto tsb.
    - error : Interface untuk listener error low level ke high level. listener ini harus dikombinasikan dengan dto diatas. Interface ini harus menjadi constructor pada class yang membutuhkan.
    - util : package class untuk util yang bersifat common, seperti validation dan converter data. GeneralValidation digunakan untuk validasi variable, GeneralConverter digunakan untuk konversi data variable.

####Contoh implementasi Parcelable pada class - class DTO.
```sh
@Parcel
public class CLAZZ{
}
```
####Contoh implementasi error listener.
```sh
public class ERROR_APP{
    private IErrorListener errorListener;
    public ERROR_APP(IErrorListener errorListener){
        this.errorListener = errorListener;
    }
    //example method
    private void errorHappened(){
        try{
            fetch_data_local();
        }Catch(Exception e){
            errorListener.getMessage(e.getLocalizedMessage);
        }
    }
}
```
Saat error terjadi pada exception diatas, maka errorListener akan bridging message error ke high level application untuk ditampilkan atau diolah lagi.

* tripoin-component
    - Penempatan asset di folder assets. ie: image, sound, font etc.
    - image : package untuk handle image processing
    - sound : package untuk handle sound processing
    - ui : package untuk handle basic ui component ( screen ). ie : fragment, activity, dialog. setiap view baik activity, fragment atau dialog harus menggunakan injeksi widget- widgetnya menggunakan butterknife (@InjectView). Kemudian, untuk action listenernya juga menggunakan butterknife. ie (@OnClick).

####Setiap activity harus extends terhadap ABaseActivity, Contoh :
```sh
public class EXAMPLE_ACTIVITY extends ABaseActivty{

@InjectView(R.id.txtTitle) public TextView txtTitle;

    String myName;

    @Override
    public void initWidget() {
        myName = "Activity Login";
        txtTitle.setText(myName);
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.activity_login;
    }
    
    @Override
    public void goToMainView(String extraKey, String extraContent) {
    }

    @OnClick(R.id.txtTitle)
    public void onTitleClick(){
        Toast.makeText(this, "Clicked ".concat(myName),Toast.LENGTH_SHORT).show();
        gotoNextActivity(ActivityMain.class, "", "");
    }
}
```
####Setiap fragment harus extends terhadap ABaseFragment/ ABaseNavDrawerFragment.Contoh :
```sh
public class FRAGMENT_SAMPLE extends ABaseNavigationDrawerFragment {

    @InjectView(R.id.txtSample) public TextView txtSample;

    private String m_data;

    @Override
    public String getFragmentTitle() {
        return null;
    }

    @Override
    public void initWidget() {
        m_data = "Sample Fragment";
    }

    @Override
    public int getViewLayoutId() {
        return 0;
    }

    @OnClick(R.id.txtSample)
    public void onClickSample(){
        Toast.makeText(getActivity(), "Clicked ".concat(m_data), Toast.LENGTH_SHORT).show();
    }
}
```

* tripoin-model
    - Setiap model harus ditandai sebagai bagian orm dengan anotasi "@DatabaseTable"
    - Model tidak boleh mengimplementasikan PARCELABLE/ SERIALIZABLE karena data model tidak boleh ditransfer. Apabila membutuhkan transfer data dari data model dapat menggunakan DTO dengan implementasi PARCELABLE.
    - Setiap Model harus didaftarkan dalam Modul tripoin-dao(DAOHelper) pada even onCreate() dan event onUpdate()
     
####Contoh model :
```sh
@DatabaseTable(tableName = ApplicationConstant.Database.TableUser.TABLE_NAME)
public class ModelUser {
    @DatabaseField(generatedId = true, canBeNull = false, columnName = ApplicationConstant.Database.ID)
    private int id;

    @DatabaseField(columnName = ApplicationConstant.Database.TableUser.USER_NAME)
    private String userName;

    @DatabaseField(columnName = ApplicationConstant.Database.TableUser.LOGIN_STATUS)
    private int loginStatus;

    @DatabaseField(columnName = ApplicationConstant.Database.TableUser.IS_ACTIVE)
    private int isActive;

    //getter - setter
	//toString if necessary
}
```

* tripoin-dao
    - Modul Data Access Object (DAO) berpusat pada DAOHelper pada inisiasi database
    - DAO yang akan ditambahkan harus extends terhadap ABaseGenericDAO
   
####Contoh DAO 
```sh
public class DAOUser extends ABaseGenericDAO {
    public DAOUser(Context ctx) {
        super(ctx);
    }
    @Override
    public Class getModelClass() {
        return ModelUser.class;
    }
}

```