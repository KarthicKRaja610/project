import speech_recognition as sr
import pyttsx3
import pywhatkit
import datetime
import wikipedia
import pyjokes

listener = sr.Recognizer()
engine = pyttsx3.init()
voices = engine.getProperty('voices')
engine.setProperty('voice',voices[1].id)

def mike():
    try:
        with sr.Microphone() as source:
            print("Listerning..")
            voice = listener.listen(source)
            command = listener.recognize_google(voice)
            command = command.lower()
            print(command)
            return command
    except:
        pass



def talk(text):
    engine.say(text)
    engine.runAndWait()


def run_alexa():
    command = mike()
    command = command.lower()
    if 'alexa' in command:
        engine.say('I am your alexa')
        engine.say('What can I do for you')
        engine.runAndWait()
    if 'play' in command:
        song = command.replace('play','')
        talk('playing '+ song)
        print(song + ' is playing')
        pywhatkit.playonyt(song)
    elif 'time' in command:
        time = datetime.datetime.now().strftime('%I:%M %p')
        print(time)
        talk('Current time is '+time)
    elif 'tell about' in command:
        person = command.replace('tell about ','')
        info = wikipedia.summary(person, 1)
        print(info)
        talk(info)
    elif 'are you single' in command:
        talk('Yes i am single')
    elif 'who is your owner' in command:
        talk('Karthickraja')
    elif 'joke' in command:
        talk(pyjokes.get_joke())
    else:
        talk('Please say the command again.')

while True:
    run_alexa()