package com.gabrielnarbona.gnb.core

import com.gabrielnarbona.gnb.data.model.Product
import java.math.RoundingMode
import java.text.DecimalFormat

class Util {
    companion object {
        fun round(double: Double): Double {
            val tmpDouble: Double
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.HALF_EVEN
            tmpDouble = df.format(double).toDouble()
            return tmpDouble
        }

        fun converter(product: Product): Double {
            val eur: Double = when (product.currency) {
                "USD" -> usdToEur(product.amount)
                "GBP" -> gbpToEur(product.amount)
                "INR" -> inrToEur(product.amount)
                "JPY" -> usdToEur(jpyToUsd(product.amount))
                "CAD" -> usdToEur(cadToUsd(product.amount))
                "SEK" -> usdToEur(sekToUsd(product.amount))
                "AUD" -> inrToEur(audToInr(product.amount))
                "RUB" -> sekToUsd(rubToSek(product.amount))
                else -> product.amount
            }
            return eur
        }

        private fun rubToSek(amount: Double): Double {
            return amount * 0.17
        }

        private fun audToInr(amount: Double): Double {
            return amount * 55.29
        }

        private fun sekToUsd(amount: Double): Double {
            return amount * 0.096
        }

        private fun cadToUsd(amount: Double): Double {
            return amount * 0.74
        }

        private fun jpyToUsd(amount: Double): Double {
            return amount * 0.0073
        }

        private fun inrToEur(amount: Double): Double {
            return amount * 0.012
        }

        private fun gbpToEur(amount: Double): Double {
            return amount * 1.16
        }

        private fun usdToEur(amount: Double): Double {
            return amount * 1.04
        }
    }
}