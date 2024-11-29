package com.example.tic_tac_toe

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.pm.ActivityInfo

class MainActivity : AppCompatActivity() {

    private var currentPlayer = "X"
    private lateinit var turnTextView: TextView
    private lateinit var board: Array<Array<Button>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        // Inicializar a TextView para exibir o turno atual
        turnTextView = findViewById(R.id.turnTV)

        // Inicializar o tabuleiro
        board = arrayOf(
            arrayOf(findViewById(R.id.a1), findViewById(R.id.a2), findViewById(R.id.a3)),
            arrayOf(findViewById(R.id.b1), findViewById(R.id.b2), findViewById(R.id.b3)),
            arrayOf(findViewById(R.id.c1), findViewById(R.id.c2), findViewById(R.id.c3))
        )

        // Configurar o botão de reinício
        val resetButton: Button = findViewById(R.id.resetButton)
        resetButton.setOnClickListener {
            resetBoard()
        }

        // Configurar os botões do tabuleiro
        for (row in board) {
            for (button in row) {
                button.setOnClickListener {
                    onButtonClick(button)
                }
            }
        }
    }

    private fun resetBoard() {
        for (row in board) {
            for (button in row) {
                button.text = ""
                button.isEnabled = true
                button.setBackgroundColor(Color.LTGRAY) // Redefinir a cor do botão
                button.contentDescription = "Empty cell"
            }
        }
        currentPlayer = "X"
        updateTurnText()
    }

    private fun onButtonClick(button: Button) {
        // Verificar se o botão já foi clicado
        if (button.text.isNotEmpty()) return

        // Marcar o botão com o jogador atual
        button.text = currentPlayer
        button.isEnabled = false
        button.contentDescription = "Cell occupied by $currentPlayer"

        // Verificar se o jogador atual venceu
        if (checkWin()) {
            onWin()
            return
        }

        // Verificar empate
        if (isBoardFull()) {
            onDraw()
            return
        }

        // Alternar para o próximo jogador
        currentPlayer = if (currentPlayer == "X") "O" else "X"
        updateTurnText()
    }

    private fun checkWin(): Boolean {
        for (i in 0..2) {
            // Verificar linhas
            if (board[i][0].text == currentPlayer &&
                board[i][1].text == currentPlayer &&
                board[i][2].text == currentPlayer) {
                return true
            }
            // Verificar colunas
            if (board[0][i].text == currentPlayer &&
                board[1][i].text == currentPlayer &&
                board[2][i].text == currentPlayer) {
                return true
            }
        }
        // Verificar diagonais
        if (board[0][0].text == currentPlayer &&
            board[1][1].text == currentPlayer &&
            board[2][2].text == currentPlayer) {
            return true
        }
        if (board[0][2].text == currentPlayer &&
            board[1][1].text == currentPlayer &&
            board[2][0].text == currentPlayer) {
            return true
        }
        return false
    }

    private fun isBoardFull(): Boolean {
        for (row in board) {
            for (button in row) {
                if (button.text.isEmpty()) return false
            }
        }
        return true
    }

    private fun updateTurnText() {
        turnTextView.text = getString(R.string.turn_text, currentPlayer)
    }

    private fun onWin() {
        Toast.makeText(this, getString(R.string.player_wins, currentPlayer), Toast.LENGTH_LONG).show()
        turnTextView.text = getString(R.string.player_wins, currentPlayer)
        disableBoard()
    }

    private fun onDraw() {
        Toast.makeText(this, getString(R.string.draw), Toast.LENGTH_LONG).show()
        turnTextView.text = getString(R.string.draw)
    }

    private fun disableBoard() {
        for (row in board) {
            for (button in row) {
                button.isEnabled = false
            }
        }
    }
}
