package com.example.a121firstapp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a121firstapp.R;
import com.example.a121firstapp.fram_account;
import com.google.android.gms.maps.GoogleMap;
import com.squareup.picasso.Picasso;

import java.util.zip.Inflater;

import static android.app.Activity.RESULT_OK;

public class fram_camera extends Fragment {
    private static final int IMAGE1=1;
    private static final int IMAGE2=2;
    private static final int IMAGE3=3;
    private static final int IMAGE4=4;
    private static final int IMAGE5=5;

    Context context;

    private Uri ImageUri;
    Toolbar toolbar;
    ImageView imageView1,imageView2,imageView3,imageView4,imageView5;

    ImageView imgTitle,imgCategory,imgTax,imgBrand,imgYear,imgCondition,imgPrice,
            imgDescription,imgDisType,imgDisAmount,imgName,imgPhone,imgPhone2,imgPhone3,imgEmail,imgAddress;
    TextView  category,Brand,TaxType,Year,Condition,Address;
    EditText Title,Price,Description,DiscoutnType,DiscountAmount,Name,Phone,Phone2,Phone3,Email;
    ImageButton add,add2;
    Button submit;


    TextInputLayout tilPhone2,tilPhone3;


    GoogleMap map;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fram_camera,container,false);



// Detail
        Title =     (EditText)    view.findViewById(R.id.etTitle);
        category =  (TextView) view.findViewById(R.id.etCategory);
        Brand =     (TextView)    view.findViewById(R.id.etBrand);
        TaxType =   (TextView)  view.findViewById(R.id.etTax);
        Year =      (TextView)     view.findViewById(R.id.etYear);
        Condition = (TextView)view.findViewById(R.id.etCondition);

        Price =       (EditText)       view.findViewById(R.id.etPrice);
        Description = (EditText) view.findViewById(R.id.etDiscription);



//Discount
        DiscoutnType =   (EditText)   view.findViewById(R.id.etDisType);
        DiscountAmount = (EditText) view.findViewById(R.id.etDisAmount);

//Contact
        Name =  (EditText)  view.findViewById(R.id.etName);
        Phone = (EditText) view.findViewById(R.id.etPhone);
        Phone2= (EditText)  view.findViewById(R.id.etPhone2);
        Phone3= (EditText)  view.findViewById(R.id.etPhone3);
        Email = (EditText) view.findViewById(R.id.etEmail);
        //   Address = (TextView) findViewById(R.id.et);

//image Detail
        imgTitle = (ImageView)    view.findViewById(R.id.imgTitle);
        imgCategory = (ImageView) view.findViewById(R.id.imgCategory);
        imgBrand = (ImageView)    view.findViewById(R.id.imgBrand);
        imgTax = (ImageView)      view.findViewById(R.id.imgTax);
        imgYear = (ImageView)     view.findViewById(R.id.imgYear);
        imgCondition = (ImageView)view.findViewById(R.id.imgCondition);
        imgPrice = (ImageView)    view.findViewById(R.id.imgPrice);
        imgDescription = (ImageView) view.findViewById(R.id.imgDescription);
        //
        imgDisType = (ImageView)  view.findViewById(R.id.imgDiscountType);
        imgDisAmount = (ImageView)view.findViewById(R.id.imgDisAmount);

        // image contact
        imgName=  (ImageView)  view.findViewById(R.id.imgName);
        imgPhone= (ImageView) view.findViewById(R.id.imgPhone);
        imgPhone2=(ImageView)view.findViewById(R.id.imgPhone2);
        imgPhone3=(ImageView)view.findViewById(R.id.imgPhone3);
        imgEmail= (ImageView) view.findViewById(R.id.imgEmail);

        //    imgAddress = (ImageView) findViewById(R.id.imgAddress);


//add phone
        tilPhone2=(TextInputLayout)view.findViewById(R.id.tilPhone2);
        tilPhone3=(TextInputLayout)view.findViewById(R.id.tilPhone3);
        add= (ImageButton)   view.findViewById(R.id.btnAdd);
        add2=(ImageButton)  view.findViewById(R.id.btnAdd2);
//toolbar and submit
        toolbar=(Toolbar) view.findViewById(R.id.tbBack);
        submit= (Button)   view.findViewById(R.id.btnSubmit);
// add image
        imageView1=(ImageView)view.findViewById(R.id.Picture1);
        imageView2=(ImageView)view.findViewById(R.id.Picture2);
        imageView3=(ImageView)view.findViewById(R.id.Picture3);
        imageView4=(ImageView)view.findViewById(R.id.Picture4);
        imageView5=(ImageView)view.findViewById(R.id.Picture5);

//***Receive data from frame account ( action edit )


        BackToolbar();
        TextEvent();
        DropList();
        Image();
        AddPhone();
        Submit();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle arg = getArguments();

        if (arg!=null){
            Brand.setText(arg.getString("brand"));
            Price.setText(Double.toString(arg.getDouble("price")));
            imageView1.setImageResource(arg.getInt("image"));
        }
    }

    private void BackToolbar() {

        toolbar.setTitle("");
        //  setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.icon_back_30px);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment someFragment = new fram_account();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, someFragment );
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });
    }


    private void TextEvent(){
        // Title
        Title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgTitle.setImageResource(R.drawable.icon_circle_null_24);
                } else if (s.length() < 3) {
                    imgTitle.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgTitle.setImageResource(R.drawable.icon_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        }); // title


// Category
        category.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() == 0) {
                    imgCategory.setImageResource(R.drawable.icon_circle_null_24);
                } else
                    imgCategory.setImageResource(R.drawable.icon_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        }); // categorylist

// TaxType
        TaxType.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() == 0) {
                    imgTax.setImageResource(R.drawable.icon_circle_null_24);
                } else
                    imgTax.setImageResource(R.drawable.icon_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        }); // TaxType

// Brand
        Brand.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgBrand.setImageResource(R.drawable.icon_circle_null_24);
                } else
                    imgBrand.setImageResource(R.drawable.icon_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        }); // brand

// Year
        Year.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() == 0) {
                    imgYear.setImageResource(R.drawable.icon_circle_null_24);
                } else
                    imgYear.setImageResource(R.drawable.icon_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });        // Year

// Condition
        Condition.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() == 0) {
                    imgCondition.setImageResource(R.drawable.icon_circle_null_24);
                } else
                    imgCondition.setImageResource(R.drawable.icon_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });     // Condition

// Discription

        Description.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgDescription.setImageResource(R.drawable.icon_circle_null_24);
                } else if (s.length() < 3) {
                    imgDescription.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgDescription.setImageResource(R.drawable.icon_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


// Price
        Price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgPrice.setImageResource(R.drawable.icon_circle_null_24);
                } else if (s.length() < 3) {
                    imgPrice.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgPrice.setImageResource(R.drawable.icon_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        }); // Price

// Name
        Name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgName.setImageResource(R.drawable.icon_circle_null_24);
                } else if (s.length() < 3) {
                    imgName.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgName.setImageResource(R.drawable.icon_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        }); //Name

// Discount Type
        DiscoutnType.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgDisType.setImageResource(R.drawable.icon_circle_null_24);
                } else if (s.length() < 3) {
                    imgDisType.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgDisType.setImageResource(R.drawable.icon_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });  // Discount type

        // Discount Amount
        DiscountAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgDisAmount.setImageResource(R.drawable.icon_circle_null_24);
                } else if (s.length() < 3) {
                    imgDisAmount.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgDisAmount.setImageResource(R.drawable.icon_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });  // Discount Amount

// Phone 1
        Phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgPhone.setImageResource(R.drawable.icon_circle_null_24);
                } else if (s.length() < 9) {
                    imgPhone.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgPhone.setImageResource(R.drawable.icon_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });  // phone1

// Phone 2
        Phone2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgPhone2.setImageResource(R.drawable.icon_circle_null_24);
                } else if (s.length() < 9) {
                    imgPhone2.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgPhone2.setImageResource(R.drawable.icon_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });  // Phone 2

// Phone 3
        Phone3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgPhone3.setImageResource(R.drawable.icon_circle_null_24);
                } else if (s.length() < 9) {
                    imgPhone3.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgPhone3.setImageResource(R.drawable.icon_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });  // Phone 3

// Email
        Email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgEmail.setImageResource(R.drawable.icon_circle_null_24);
                } else if (s.length() < 3) {
                    imgEmail.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgEmail.setImageResource(R.drawable.icon_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        }); // email


    }
    private void DropList(){
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu pop_category= new PopupMenu(getContext(),v, Gravity.RIGHT);
                pop_category.getMenuInflater().inflate(R.menu.categorylist,pop_category.getMenu());


                pop_category.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        category.setText(item.getTitle());
                        return true;
                    }
                });
                pop_category.show();
            }
        });


// tax type


        TaxType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu pop_tax= new PopupMenu(getContext(),v,Gravity.RIGHT);
                pop_tax.getMenuInflater().inflate(R.menu.taxlist,pop_tax.getMenu());

                pop_tax.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        TaxType.setText(item.getTitle());
                        return true;
                    }
                });
                pop_tax.show();
            }
        });

// Brand
        Brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu pop_brand= new PopupMenu(getContext(),v,Gravity.RIGHT);
                pop_brand.getMenuInflater().inflate(R.menu.brandlist,pop_brand.getMenu());

                pop_brand.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Brand.setText(item.getTitle());
                        return true;
                    }
                });
                pop_brand.show();
            }
        });
// Year
        Year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu pop_year= new PopupMenu(getContext(),v,Gravity.RIGHT);
                pop_year.getMenuInflater().inflate(R.menu.yearlist,pop_year.getMenu());

                pop_year.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Year.setText(item.getTitle());
                        return true;
                    }
                });
                pop_year.show();
            }
        });

// Condition
        Condition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu pop_condition= new PopupMenu(getContext(),v,Gravity.RIGHT);
                pop_condition.getMenuInflater().inflate(R.menu.conditionlist,pop_condition.getMenu());

                pop_condition.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Condition.setText(item.getTitle());
                        return true;
                    }
                });
                pop_condition.show();
            }
        });

    }

    private void Image(){

        imageView1.setImageResource(R.drawable.ic_add_a_photo_black_24dp);
        imageView2.setImageResource(R.drawable.ic_add_box_black_24dp);
        imageView3.setImageResource(R.drawable.ic_add_box_black_24dp);
        imageView4.setImageResource(R.drawable.ic_add_box_black_24dp);
        imageView5.setImageResource(R.drawable.ic_add_box_black_24dp);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,IMAGE1);

            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,IMAGE2);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,IMAGE3);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,IMAGE4);
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,IMAGE5);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode==IMAGE1 && resultCode== RESULT_OK && null != data){
            ImageUri= data.getData();

            Picasso.with(getActivity()).load(ImageUri).into(imageView1);
        }else  if(resultCode==RESULT_OK && requestCode==IMAGE2 && null != data) {
            ImageUri = data.getData();
            Picasso.with(getActivity()).load(ImageUri).into(imageView2);
        }else  if(resultCode==RESULT_OK && requestCode==IMAGE3 && null != data) {
            ImageUri = data.getData();
            Picasso.with(getActivity()).load(ImageUri).into(imageView3);
        }else  if(resultCode==RESULT_OK && requestCode==IMAGE4 && null != data) {
            ImageUri = data.getData();
            Picasso.with(getActivity()).load(ImageUri).into(imageView4);
        }else  if(resultCode==RESULT_OK && requestCode==IMAGE5 && null != data) {
            ImageUri = data.getData();
            Picasso.with(getActivity()).load(ImageUri).into(imageView5);
        }
    }

    private void AddPhone(){

        tilPhone2.setVisibility(View.GONE);

        tilPhone3.setVisibility(View.GONE);


        add2.setVisibility(View.GONE);

        add.setVisibility(View.VISIBLE);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tilPhone2.setVisibility(View.VISIBLE);
                add2.setVisibility(View.VISIBLE);
                add.setVisibility(View.GONE);
            }
        });

        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tilPhone3.setVisibility(View.VISIBLE);
                add2.setVisibility(View.GONE);
            }
        });

    }

    private void Submit(){

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Submit",Toast.LENGTH_SHORT).show();


            }
        });
    }
}
