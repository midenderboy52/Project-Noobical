import os
import socket
import subprocess
from subprocess import PIPE , STDOUT
import winsound


#My biggest project yet and this is 204 lines of code!
    
def get_currentworking_directory():
    chf = os.getcwd()
    return chf
        
def make_folder(ll):
    os.mkdir(ll)
    
    
def make_file(ll):
    with open(ll , 'w') as f:
        f.close()
        
def run_commands_in_cmd(cmd):
    p = subprocess.run(cmd.split(), shell=True, stdin=PIPE, stdout=PIPE, stderr=STDOUT, close_fds=True)
    output = p.stdout.decode()
    return str(output)
    
def delete_file(kk):
    os.remove(kk)
        
def delete_folder(folder_name):
    os.rmdir(folder_name)
        
        
def list_of_dir(ll):
    a = os.listdir(str(ll))
    return str(a)

def shutdown():
    subprocess.run('shutdown /s')

def Credits():
    print('Made by midenderboy52')
    
def set_cur_dir(ll):
    os.chdir(ll)

    
    
    
while True:

    first_input = 90
    
    try: 
        first_input = int(input('[' + '1'  + ']' + ' Start Server!' + '\n' + '[' + '2' +  ']' +  ' Creator Details!' + '\n'  + '>'))
    except ValueError:
        print("Please select within the options!")



    if first_input == 1:
    
        try:
            winsound.Beep(5000 , 100)
            second_input = input('Ip adress : - ')
            winsound.Beep(5000, 100)
            third_input = int(input('Port : - '))
            winsound.Beep(5000, 100)
            s = socket.socket(socket.AF_INET , socket.SOCK_STREAM)
            s.bind((second_input , third_input))
            s.listen(1)
            while True:
                a , b = s.accept()
                print(f'Connection found from : - {b}')
                h = a.recv(1024)
                j = h.decode('utf-8')
                lol = str(j)
            
            
            
            
            
                #Sending the current working directory
                if lol.strip() == "getcurdir":
                    a.send(bytes(get_currentworking_directory() , 'utf-8'))
                
            
            
                
                
                #Running commands in the cmd!    
                elif "cmd" in lol:
                    if lol[0] == "c" and lol[1] == "m" and lol[2] == "d":
                        h = []
                        for i in range(3 , len(lol.strip())):
                            h.append(lol[i])
                        makeitastring = ''.join(map(str, h))
                    a.send(bytes(run_commands_in_cmd(makeitastring) , 'utf-8'))
                
            
            
                
                
                
                #Setting current dir!    
                elif "set" in lol:
                    if lol[0] == "s" and lol[1] == "e" and lol[2] == "t":
                        hp = []
                        for i in range(3 , len(lol.strip())):
                            hp.append(lol[i])
                        makeitastrings = ''.join(map(str, hp))
                    set_cur_dir(makeitastrings)
                    a.send(bytes("Done!" , 'utf-8'))
                
            
            
                
                
                #Sending dirs in a location in list!    
                elif "lir" in lol:
                    if lol[0] == "l" and lol[1] == "i" and lol[2] == "r":
                        hpp = []
                        for i in range(3 , len(lol.strip())):
                            hpp.append(lol[i])
                        makeitastrin = ''.join(map(str, hpp))
                    jjoo = str(makeitastrin)
                    a.send(bytes(list_of_dir(jjoo) , 'utf-8'))
                
            
            
                
                #Make a folder!
                elif "maf" in lol:
                    if lol[0] == "m" and lol[1] == "a" and lol[2] == "f":
                        hppp = []
                        for i in range(3 , len(lol.strip())):
                            hppp.append(lol[i])
                        makeitastrinn = ''.join(map(str, hppp))
                    make_folder(makeitastrinn)
                    a.send(bytes("Done!", 'utf-8'))
            
            
                
                #Make a file
                elif "mag" in lol:
                    if lol[0] == "m" and lol[1] == "a" and lol[2] == "g":
                        hpppp = []
                        for i in range(3 , len(lol.strip())):
                            hpppp.append(lol[i])
                        makeitastrinnn = ''.join(map(str, hpppp))
                    make_file(makeitastrinnn)
                    a.send(bytes("Done!", 'utf-8'))
            
            
                #Delete a folder!
                elif "def" in lol:
                    if lol[0] == "d" and lol[1] == "e" and lol[2] == "f":
                        hppppp = []
                        for i in range(3 , len(lol.strip())):
                            hppppp.append(lol[i])
                        makeitastrinnnn = ''.join(map(str, hppppp))
                    delete_folder(makeitastrinnnn)
                    a.send(bytes("Done!", 'utf-8'))
            
            
            
            #Delete a file!
                elif "del" in lol:
                    if lol[0] == "d" and lol[1] == "e" and lol[2] == "l":
                        hpppppp = []
                        for i in range(3 , len(lol.strip())):
                            hpppppp.append(lol[i])
                        makeitastrinnnnn = ''.join(map(str, hpppppp))
                    delete_file(makeitastrinnnnn)
                    a.send(bytes("Done!", 'utf-8'))
                
                
                
                #Shutting down!
                elif "shutdown" in lol:
                    shutdown()
                    a.send(bytes("Shutting down" , "utf-8"))

                
                
            
        except OSError:
            print("An error occured!")
            s.close()
            pass
        except NameError:
            print('Error Occured!')
            s.close()
            pass
        except ValueError:
            print('Nothing is suplied!')
            s.close()
            pass
        except:
            print("An Error Occured!")
            s.close()
            pass


    elif first_input == 2:
        winsound.Beep(5000, 100)
        Credits()
    else:
        winsound.Beep(5000, 100)
        print('No such options avaliable!')