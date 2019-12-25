package Task7;

import Task7.Abstracts.Wild;

public class Giraffe extends Wild {

    // знаю, что по умолчанию isPredator будет false
    // но для красивого кода все таки пусть будет явное указание
    public Giraffe() {
        setPredator(false);
    }


}
