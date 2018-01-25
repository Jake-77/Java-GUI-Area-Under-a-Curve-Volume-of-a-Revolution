package com.company;
public class Main {

    chooseMethod choose = new chooseMethod();

    volumeOfRevolution volume = new volumeOfRevolution();

    areaChoose aC = new areaChoose();

    areaSine aS = new areaSine();
    areaCosine aCS = new areaCosine();
    areaLinear aL = new areaLinear();
    areaQuad aQ = new areaQuad();

    public static void main(String[] args) {

        chooseMethod choose = new chooseMethod();

        volumeOfRevolution volume = new volumeOfRevolution();

        areaChoose aC = new areaChoose();

        areaSine aS = new areaSine();
        areaCosine aCS = new areaCosine();
        areaLinear aL = new areaLinear();
        areaQuad aQ = new areaQuad();


        GUIframe aFrame = new GUIframe();
        aFrame.setVisible(true);

        choose.setVisible(false);

        volume.setVisible(false);

        aC.setVisible(false);

        aS.setVisible(false);
        aCS.setVisible(false);
        aL.setVisible(false);
        aQ.setVisible(false);


    }


}
