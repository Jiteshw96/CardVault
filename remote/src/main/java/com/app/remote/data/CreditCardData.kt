package com.app.remote.data


import com.app.remote.R
import com.app.remote.model.RewardRemote
import com.app.remote.model.CreditCardDataRemote
import com.app.remote.model.CreditCardRemote

object CreditCardData {
    val creditCardRemoteData = CreditCardDataRemote(
         creditCards = listOf(
             CreditCardRemote(
                 name = "Travel Elite Card",
                 image = R.drawable.student_card,
                 rewards = listOf(
                     RewardRemote("Airline miles", "2 miles per $1 spent on travel", R.drawable.aiport),
                     RewardRemote("Travel statement credits", "$200 annual travel credit", R.drawable.bonus_points),
                     RewardRemote("No foreign transaction fees", "Zero fees on international purchases", R.drawable.foreign),
                     RewardRemote("Concierge services", "24/7 concierge support for travel bookings", R.drawable.concierge),
                     RewardRemote("Free checked bags", "1 free checked bag on all flights", R.drawable.cardbenefits),
                     RewardRemote("Discount on travel bookings", "5% discount on flight bookings", R.drawable.travel_booking)
                 )
             ),
            CreditCardRemote(
                name = "Premium Rewards Card",
                image = R.drawable.travel_card,
                rewards = listOf(
                    RewardRemote("Travel insurance coverage", "Up to $500,000 coverage", R.drawable.travel_insurance),
                    RewardRemote("Airport lounge access", "Access to 2 lounges per year", R.drawable.aiport),
                    RewardRemote("Cash back", "2% cash back on all purchases", R.drawable.cashback),
                    RewardRemote("Free hotel upgrades", "Free room upgrades at select hotels", R.drawable.cardbenefits),
                    RewardRemote("Sign-up bonus", "30,000 bonus points after spending $3,000 in 3 months", R.drawable.signup)
                )
            ),
            CreditCardRemote(
                name = "Cash Back MasterCard",
                image = R.drawable.gold_card,
                rewards = listOf(
                    RewardRemote("VIP event access", "2 VIP event access per year", R.drawable.vip_access),
                    RewardRemote("Cash back", "1.5% cash back on every purchase", R.drawable.cashback),
                    RewardRemote("Extended warranties", "Up to 1 extra year on warranties", R.drawable.cardbenefits),
                    RewardRemote("Bonus points", "15 bonus points for every $100 spent", R.drawable.bonus_points),
                    RewardRemote("Purchase protection", "Protection on purchases for 90 days", R.drawable.cardbenefits)
                )
            ),
            CreditCardRemote(
                name = "Luxury Rewards Visa",
                image = R.drawable.platinum_card,
                rewards = listOf(
                    RewardRemote("Hotel loyalty points", "Earn 3 points per $1 spent at hotels", R.drawable.bonus_points),
                    RewardRemote("Free hotel upgrades", "Upgrade to suite at select hotels", R.drawable.travel_booking),
                    RewardRemote("Luxury hotel collection benefits", "VIP perks at 1,000+ luxury hotels", R.drawable.vip_access),
                    RewardRemote("Special financing offers", "12-month no-interest financing on big purchases", R.drawable.cardbenefits),
                    RewardRemote("Charity donations with points", "Donate 1,000 points for $10 to charity", R.drawable.bonus_points)
                )
            ),
            CreditCardRemote(
                name = "Everyday Cash Card",
                image = R.drawable.silver_card,
                rewards = listOf(
                    RewardRemote("0% APR on purchases for 12 months", "No interest for the first 12 months on new purchases", R.drawable.apr),
                    RewardRemote("Cash back on specific categories", "5% cash back on rotating categories", R.drawable.cashback),
                    RewardRemote("Purchase protection", "Protection against damage or theft for 90 days", R.drawable.travel_insurance),
                    RewardRemote("Extended warranties", "Extra year of warranty on eligible items", R.drawable.concierge),
                    RewardRemote("Reward multipliers for groceries", "3 points per $1 spent on groceries", R.drawable.bonus_points),
                    RewardRemote("Cashback on recurring subscriptions", "1% cash back on subscriptions like Netflix", R.drawable.signup)
                )
            )
        )
    )
}