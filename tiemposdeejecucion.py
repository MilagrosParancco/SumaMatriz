import tkinter as tk
from tkinter import messagebox
import matplotlib.pyplot as plt
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg

def mostrar_grafico():

    dimensiones = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
    tiempos_ejecucion = [46, 49, 53, 62, 75, 91, 104, 127, 163, 180]
    
    fig, ax = plt.subplots(figsize=(10, 5))
    
    ax.plot(dimensiones, tiempos_ejecucion, marker='o', linestyle='-', color='b')
    ax.set_title('Tiempo de Ejecución vs Dimensión de la Matriz')
    ax.set_xlabel('Dimensión de la Matriz (n x n)')
    ax.set_ylabel('Tiempo de Ejecución (ms)')
    ax.set_xticks(dimensiones)  
    ax.grid()

    
    canvas = FigureCanvasTkAgg(fig, master=ventana)  
    canvas.draw()
    canvas.get_tk_widget().pack()  


ventana = tk.Tk()
ventana.title("Gráfico de Tiempos de Ejecución")

boton_mostrar = tk.Button(ventana, text="Mostrar Gráfico", command=mostrar_grafico)
boton_mostrar.pack(pady=20)

ventana.mainloop()