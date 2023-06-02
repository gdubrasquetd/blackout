package fr.guillaume.BlackOut;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static fr.guillaume.BlackOut.HomePage.tmp;

public class PersonalizePage extends Activity {

    static List<String> actionPerso = new ArrayList<String>();
    static List<String> veritePerso = new ArrayList<String>();


    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;

    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private TextView text5;
    private TextView text6;
    private TextView text7;
    private TextView text8;
    private TextView text9;
    private TextView text10;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.personalizepage);
        Button action = findViewById(R.id.action);
        Button verite = findViewById(R.id.verite);
        Button menu = findViewById(R.id.menu);

        System.out.println(tmp);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);
        text6 = findViewById(R.id.text6);
        text7 = findViewById(R.id.text7);
        text8 = findViewById(R.id.text8);
        text9 = findViewById(R.id.text9);
        text10 = findViewById(R.id.text10);

        refresh();

        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTextDialog('a');
            }

        });
        verite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTextDialog('v');
            }

        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(PersonalizePage.this, HomePage.class);
                startActivity(myIntent);
                finish();
            }

        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button1.getVisibility() == View.VISIBLE) {
                    String a = tmp.get(0);
                    tmp.remove(0);
                    actionPerso.remove(a);
                    veritePerso.remove(a);
                    refresh();
                }
            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button2.getVisibility() == View.VISIBLE) {
                    String a = tmp.get(1);
                    tmp.remove(1);
                    actionPerso.remove(a);
                    veritePerso.remove(a);
                    refresh();
                }
            }

        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button3.getVisibility() == View.VISIBLE) {
                    String a = tmp.get(2);
                    tmp.remove(2);
                    actionPerso.remove(a);
                    veritePerso.remove(a);
                    refresh();
                }
            }

        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button4.getVisibility() == View.VISIBLE) {
                    String a = tmp.get(3);
                    tmp.remove(3);
                    actionPerso.remove(a);
                    veritePerso.remove(a);
                    refresh();
                }
            }

        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button5.getVisibility() == View.VISIBLE) {
                    String a = tmp.get(4);
                    tmp.remove(4);
                    actionPerso.remove(a);
                    veritePerso.remove(a);
                    refresh();
                }
            }

        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button6.getVisibility() == View.VISIBLE) {
                    String a = tmp.get(5);
                    tmp.remove(5);
                    actionPerso.remove(a);
                    veritePerso.remove(a);
                    refresh();
                }
            }

        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button7.getVisibility() == View.VISIBLE) {
                    String a = tmp.get(6);
                    tmp.remove(6);
                    actionPerso.remove(a);
                    veritePerso.remove(a);
                    refresh();
                }
            }

        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button8.getVisibility() == View.VISIBLE) {
                    String a = tmp.get(7);
                    tmp.remove(7);
                    actionPerso.remove(a);
                    veritePerso.remove(a);
                    refresh();
                }
            }

        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button9.getVisibility() == View.VISIBLE) {
                    String a = tmp.get(8);
                    tmp.remove(8);
                    actionPerso.remove(a);
                    veritePerso.remove(a);
                    refresh();
                }
            }

        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button10.getVisibility() == View.VISIBLE) {
                    String a = tmp.get(9);
                    tmp.remove(9);
                    actionPerso.remove(a);
                    veritePerso.remove(a);
                    refresh();
                }
            }

        });

    }


    private void showTextDialog(final char type) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        if (type == 'a') {
            builder.setTitle("Ajouter une action");
        }
        if (type == 'v') {
            builder.setTitle("Ajouter une vérité");
        }

// Set up the input
        final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        builder.setView(input);
        builder.setMessage("Utilisez les balises suivantes pour cibler une personne: \n \n \"-A\" : Aléatoire\n \"-O\" : Sexe opposé \n \"-S\" : Même sexe \n \"-H\" : Homme \n \"-F\" : Femme");

// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            private String EnteredText;

            @Override
            public void onClick(DialogInterface dialog, int which) {

                EnteredText = input.getText().toString();
                EnteredText = EnteredText.replace('%', ' ');
                EnteredText = EnteredText.replace("-A", "%s");
                EnteredText = EnteredText.replace("-O", "%2$s");
                EnteredText = EnteredText.replace("-S", "%3$s");
                EnteredText = EnteredText.replace("-H", "%4$s");
                EnteredText = EnteredText.replace("-F", "%5$s");

                if (!EnteredText.isEmpty()) {
                    if (type == 'v') {
                        veritePerso.add(EnteredText + "\n\n Ou bois 3 gorgées !");

                        if (EnteredText.length() >= 55) {
                            tmp.add(EnteredText.substring(0, 55) + "...");
                        } else {
                            tmp.add(EnteredText);
                        }

                        Toast.makeText(getApplicationContext(), "Vérité ajoutée avec succès", Toast.LENGTH_SHORT).show();
                    }
                    if (type == 'a') {
                        actionPerso.add(EnteredText + "\n\n Ou bois 3 gorgées !");

                        if (EnteredText.length() >= 55) {
                            tmp.add(EnteredText.substring(0, 55) + "...");
                        } else {
                            tmp.add(EnteredText);
                        }

                        Toast.makeText(getApplicationContext(), "Action ajoutée avec succès", Toast.LENGTH_SHORT).show();
                    }
                    refresh();
                }
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private void refresh() {
        if (tmp.size() >= 1) {
            text1.setText(tmp.get(0));
            button1.setVisibility(View.VISIBLE);
        } else {
            text1.setText("");
            button1.setVisibility(View.INVISIBLE);
        }
        if (tmp.size() >= 2) {
            text2.setText(tmp.get(1));
            button2.setVisibility(View.VISIBLE);
        } else {
            text2.setText("");
            button2.setVisibility(View.INVISIBLE);
        }
        if (tmp.size() >= 3) {
            text3.setText(tmp.get(2));
            button3.setVisibility(View.VISIBLE);
        } else {
            text3.setText("");
            button3.setVisibility(View.INVISIBLE);
        }
        if (tmp.size() >= 4) {
            text4.setText(tmp.get(3));
            button4.setVisibility(View.VISIBLE);
        } else {
            text4.setText("");
            button4.setVisibility(View.INVISIBLE);
        }
        if (tmp.size() >= 5) {
            text5.setText(tmp.get(4));
            button5.setVisibility(View.VISIBLE);
        } else {
            text5.setText("");
            button5.setVisibility(View.INVISIBLE);
        }
        if (tmp.size() >= 6) {
            text6.setText(tmp.get(5));
            button6.setVisibility(View.VISIBLE);
        } else {
            text6.setText("");
            button6.setVisibility(View.INVISIBLE);
        }
        if (tmp.size() >= 7) {
            text7.setText(tmp.get(6));
            button7.setVisibility(View.VISIBLE);
        } else {
            text7.setText("");
            button7.setVisibility(View.INVISIBLE);
        }
        if (tmp.size() >= 8) {
            text8.setText(tmp.get(7));
            button8.setVisibility(View.VISIBLE);
        } else {
            text8.setText("");
            button8.setVisibility(View.INVISIBLE);
        }
        if (tmp.size() >= 9) {
            text9.setText(tmp.get(8));
            button9.setVisibility(View.VISIBLE);
        } else {
            text9.setText("");
            button9.setVisibility(View.INVISIBLE);
        }
        if (tmp.size() >= 10) {
            text10.setText(tmp.get(9));
            button10.setVisibility(View.VISIBLE);
        } else {
            text10.setText("");
            button10.setVisibility(View.INVISIBLE);
        }

    }

}
