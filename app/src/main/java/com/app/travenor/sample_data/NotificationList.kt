package com.app.travenor.sample_data

import androidx.annotation.DrawableRes
import com.app.travenor.R
import kotlinx.serialization.Serializable

@Serializable
data class Notification(
    val id: Int,
    val notificationTitle: String,
    val notificationDesc: String,
    val notificationTime: String,
    val notificationIcon: String,
    @DrawableRes val placeHolderIcon: Int
)

val notificationList = listOf(
    Notification(
        id = 0,
        notificationTitle = "Exclusive Travel Deals",
        notificationDesc = "Discover incredible vacation packages with unbeatable discounts! Explore exotic destinations, luxury resorts, and adventure trips tailored to your dream holiday experience and budget.",
        notificationIcon = "https://cdn-icons-png.flaticon.com/512/2919/2919906.png",
        notificationTime = "Mon,02:15pm",
        placeHolderIcon = R.drawable.profile_ph1
    ),
    Notification(
        id = 1,
        notificationTitle = "Tech Gadget Bonanza",
        notificationDesc = "Unleash the latest technological marvels with our incredible electronics sale! Discover cutting-edge smartphones, smart home devices, and revolutionary gadgets at unprecedented price reductions.",
        notificationIcon = "https://img.freepik.com/premium-vector/student-avatar-illustration-user-profile-icon-youth-avatar_118339-4405.jpg",
        notificationTime = "Tue,11:30am",
        placeHolderIcon = R.drawable.profile_ph2
    ),
    Notification(
        id = 2,
        notificationTitle = "Fashion Style Revolution",
        notificationDesc = "Transform your wardrobe with our exclusive designer collection! Experience trendsetting fashion, premium fabrics, and stunning styles that capture the essence of modern elegance and personal expression.",
        notificationIcon = "https://img.freepik.com/premium-photo/cartoon-boy-with-glasses-smiling-modern-line-icon-avatar_1106493-512908.jpg",
        notificationTime = "Wed,03:45pm",
        placeHolderIcon = R.drawable.profile_ph3
    ),
    Notification(
        id = 3,
        notificationTitle = "Gourmet Culinary Experience",
        notificationDesc = "Elevate your dining experience with our premium culinary selections! Discover restaurant-quality ingredients, exotic spices, and meal kits that bring world-class cuisine directly to your kitchen.",
        notificationIcon = "https://picsbed.top/file/oFWsedso%2FpQ9yeDpEvaEqEO4UvrWajYdGOem1ePC9Is%3D",
        notificationTime = "Thu,07:20pm",
        placeHolderIcon = R.drawable.profile_ph4
    ),
    Notification(
        id = 4,
        notificationTitle = "Wellness Journey Starts",
        notificationDesc = "Embark on a transformative health and wellness adventure! Discover comprehensive fitness programs, nutritional guidance, mental health resources, and holistic approaches to personal well-being.",
        notificationIcon = "https://img.freepik.com/premium-vector/businessman-avatar-illustration-cartoon-user-portrait-user-profile-icon_118339-5502.jpg",
        notificationTime = "Fri,10:10am",
        placeHolderIcon = R.drawable.profile_ph5
    ),
    Notification(
        id = 5,
        notificationTitle = "Home Decor Makeover",
        notificationDesc = "Reimagine your living spaces with our stunning interior design collection! Explore innovative furniture, decorative accessories, and contemporary design solutions that breathe life into your home.",
        notificationIcon = "https://png.pngtree.com/png-clipart/20240723/original/pngtree-flat-people-man-icon-illustration-vector-png-image_15612321.png",
        notificationTime = "Sat,01:55pm",
        placeHolderIcon = R.drawable.profile_ph6
    ),
    Notification(
        id = 6,
        notificationTitle = "Educational Breakthrough Network",
        notificationDesc = "Unlock your potential with our comprehensive learning platform! Access world-class courses, skill development programs, and expert-led tutorials across diverse fields of knowledge and expertise.",
        notificationIcon = "https://img.freepik.com/premium-photo/profile-icon-white-background_941097-162565.jpg",
        notificationTime = "Sun,04:30am",
        placeHolderIcon = R.drawable.profile_ph7
    ),
    Notification(
        id = 7,
        notificationTitle = "Green Energy Solutions",
        notificationDesc = "Revolutionize your environmental impact with sustainable energy innovations! Explore solar technologies, eco-friendly products, and renewable energy solutions for a greener, cleaner future.",
        notificationIcon = "https://img.freepik.com/premium-vector/businessman-avatar-illustration-cartoon-user-portrait-user-profile-icon_118339-5502.jpg",
        notificationTime = "Mon,09:45am",
        placeHolderIcon = R.drawable.profile_ph5
    ),
    Notification(
        id = 8,
        notificationTitle = "Financial Freedom Path",
        notificationDesc = "Master your financial journey with expert-guided investment strategies! Learn about wealth management, smart savings, cryptocurrency insights, and personalized financial planning techniques.",
        notificationIcon = "https://png.pngtree.com/png-clipart/20240723/original/pngtree-flat-people-man-icon-illustration-vector-png-image_15612321.png",
        notificationTime = "Tue,06:15pm",
        placeHolderIcon = R.drawable.profile_ph6
    ),
    Notification(
        id = 9,
        notificationTitle = "Adventure Travel Club",
        notificationDesc = "Break free from routine and explore extraordinary destinations! Join our exclusive travel community offering unique experiences, hidden gems, and thrilling expeditions around the globe.",
        notificationIcon = "https://img.freepik.com/premium-photo/profile-icon-white-background_941097-162565.jpg",
        notificationTime = "Wed,11:20am",
        placeHolderIcon = R.drawable.profile_ph7
    ),
    Notification(
        id = 10,
        notificationTitle = "Digital Marketing Mastery",
        notificationDesc = "Transform your online presence with cutting-edge digital marketing strategies! Learn advanced techniques, social media optimization, content creation, and brand development from industry experts.",
        notificationIcon = "https://img.freepik.com/premium-vector/businessman-avatar-illustration-cartoon-user-portrait-user-profile-icon_118339-5502.jpg",
        notificationTime = "Thu,02:40pm",
        placeHolderIcon = R.drawable.profile_ph5
    ),
    Notification(
        id = 11,
        notificationTitle = "Fitness Transformation Challenge",
        notificationDesc = "Unlock your ultimate physical potential with our comprehensive fitness transformation program! Personalized workouts, nutrition plans, and motivational coaching to achieve your health goals.",
        notificationIcon = "https://png.pngtree.com/png-clipart/20240723/original/pngtree-flat-people-man-icon-illustration-vector-png-image_15612321.png",
        notificationTime = "Fri,05:55am",
        placeHolderIcon = R.drawable.profile_ph6
    ),
    Notification(
        id = 12,
        notificationTitle = "Sustainable Living Guide",
        notificationDesc = "Embrace an eco-conscious lifestyle with our comprehensive sustainable living resources! Discover practical tips, innovative products, and transformative strategies for reducing your environmental footprint.",
        notificationIcon = "https://img.freepik.com/premium-photo/profile-icon-white-background_941097-162565.jpg",
        notificationTime = "Sat,08:30pm",
        placeHolderIcon = R.drawable.profile_ph7
    )
)

