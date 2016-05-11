def names = []
def readln = javax.swing.JOptionPane.&showInputDialog
def username = readln 'What is your name?'
while(username != null) {
    names.add(username)
    readln = javax.swing.JOptionPane.&showInputDialog
    username = readln 'What is your name?'
}

Random random = new Random()
def pickedNumbers = []
int breaker = 0

for(int i = 0; i < names.size(); i++) {
    int randomNumber = i
    if( i == names.size - 1 && !pickedNumbers.contains(i) ) {
        pickedNumbers = []
        i = -1
    }
    else {
        while ( randomNumber == i ) { 
            randomNumber = random.nextInt(names.size)
             if(pickedNumbers.contains(randomNumber)) {
                 randomNumber = i
             }
            breaker ++
            if( breaker > 1000 ) {
                def dialog = javax.swing.JOptionPane.&showMessageDialog
                dialog (null, "Failed to converge!", "Failure!", javax.swing.JOptionPane.INFORMATION_MESSAGE)
                dialog = javax.swing.JOptionPane.&showMessageDialog
                return null
            }
        }
        pickedNumbers.add(randomNumber)
    }
}

names.eachWithIndex { it, i ->
    def dialog = javax.swing.JOptionPane.&showMessageDialog
    dialog (null, it + " get your name \n", "Next", javax.swing.JOptionPane.INFORMATION_MESSAGE)
    dialog = javax.swing.JOptionPane.&showMessageDialog
    dialog (null, it + " picked " + names[pickedNumbers[i]], "Name", javax.swing.JOptionPane.INFORMATION_MESSAGE)
}
null