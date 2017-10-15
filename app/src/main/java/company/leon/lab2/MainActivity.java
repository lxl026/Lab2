package company.leon.lab2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView mImage = (ImageView) findViewById(R.id.imageView) ;
        mImage.setOnClickListener(new View.OnClickListener(){
            final String[] items = new String[] { "拍摄", "从相册选择" };
            @Override
            public void onClick(View view){
                AlertDialog.Builder mBuilder=new AlertDialog.Builder(MainActivity.this);
                mBuilder.setTitle("上传头像");
                mBuilder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "您选择了["+items[i]+"]", Toast.LENGTH_SHORT).show();
                    }
                });
                mBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"您选择了[取消]", Toast.LENGTH_SHORT).show();
                    }
                });
                mBuilder.setCancelable(true);
                mBuilder.show();

            }

        });
        RadioGroup mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                boolean which=(checkedId==R.id.radioButton_student);
                if(which)
                {
                    Snackbar.make(findViewById(R.id.radioGroup),"您选择了学生",Snackbar.LENGTH_SHORT)
                            .setAction("确定",new View.OnClickListener(){
                                @Override
                                public void onClick(View view){
                                    Toast.makeText(getApplicationContext(),"Snackbar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                            .show();

                }
                else
                {
                    Snackbar.make(findViewById(R.id.radioGroup),"您选择了教职工",Snackbar.LENGTH_SHORT)
                            .setAction("确定",new View.OnClickListener(){
                                @Override
                                public void onClick(View view){
                                    Toast.makeText(getApplicationContext(),"Snackbar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                            .show();
                }
            }
        });


        final TextInputLayout mNumberText = (TextInputLayout)findViewById(R.id.Textip_SID);
        final TextInputLayout mPassText =(TextInputLayout)findViewById(R.id.Textip_PW);
        final EditText mNumberEdit = mNumberText.getEditText();
        final EditText mPassEdit = mPassText.getEditText();


        Button Login=(Button) findViewById(R.id.login);
        Button Signup=(Button)findViewById(R.id.sigup);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mNumberEdit.getText().toString().equals(""))
                {
                    mNumberText.setErrorEnabled(true);
                    mNumberText.setError("学号不能为空");
                }
                else if(mPassEdit.getText().toString().equals(""))
                {
                    mNumberText.setErrorEnabled(false);
                    mPassText.setErrorEnabled(true);
                    mPassText.setError("密码不能为空");
                }
                else if(mNumberEdit.getText().toString().equals("123456")&&mPassEdit.getText().toString().equals("6666"))
                {
                    Snackbar.make(findViewById(R.id.radioGroup),"登录成功",Snackbar.LENGTH_SHORT)
                            .setAction("确定",new View.OnClickListener(){
                                @Override
                                public void onClick(View view){
                                    Toast.makeText(getApplicationContext(),"Snackbar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                            .show();
                    mNumberText.setErrorEnabled(false);
                    mPassText.setErrorEnabled(false);
                }
                else
                {
                    Snackbar.make(findViewById(R.id.radioGroup),"学号或密码错误",Snackbar.LENGTH_SHORT)
                            .setAction("确定",new View.OnClickListener(){
                                @Override
                                public void onClick(View view){
                                    Toast.makeText(getApplicationContext(),"Snackbar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                            .show();
                    mNumberText.setErrorEnabled(false);
                    mPassText.setErrorEnabled(false);
                }
            }
        });
    }
}
