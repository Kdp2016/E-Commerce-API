package com;

import com.product.Products;
import com.user.Users;
import com.product.ProductRepository;
import com.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class EcommerceApp implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Autowired
    public EcommerceApp(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApp.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Users user = new Users("Goku", "Kakarot", "goku@gmail.com", "password123", Users.Role.SELLER);

        List<Products> productList = new ArrayList<Products>();
        productList.addAll(Arrays.asList(
                new Products("Airpods Wireless Bluetooth Headphones", "Bluetooth technology lets you connect it with compatible devices wirelessly High-quality AAC audio offers immersive listening experience Built-in microphone allows you to take calls while working", "https://i5.walmartimages.com/asr/fa0e28a5-90ab-422d-9abb-28266e4d0f37.3f34e2517de9cf2aa390e7197f1d7580.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF", "Apple", 89.99, user, Products.Categories.ELECTRONICS),
                new Products("Body Glove Men's Dual-Size Evoprene PFD, Life Jacket", "U.S. Coast Guard Approved and unique style make the Men's Body Glove Personal Flotation Device (PFD) the perfect option on water. It may be the most important piece of equipment you'll ever own. It has concealed back and side straps, and strategically placed drain holes for shedding water. When essential equipment is designed with performance and comfort in mind, you get the industry-leading selection before you. Show your style with our black and green colored PFD, you'll be glad you did!.", "https://i5.walmartimages.com/asr/0d6065d6-d107-40bc-891c-16966d53fab9.93043824b81bfb71dbbdaa0c54353d77.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF", "Body Glove", 38.97, user, Products.Categories.OUTDOORS),
                new Products("GTRACING 2022 Gaming Chair", "GTRACING gaming chair is your ideal choice for working, studying, and gaming. The GTRACING 099 series with ergonomic design is one of the classical series among our products. With an adjustable headrest and lumbar pillow, it comforts both the cervical and lumbar spine. The racing-style angle adjustor helps you enjoy reclining and rocking at the same time. Seat cushion and chair back full of high-density sponge keep you comfortable after day-long sitting. The ergonomic design and high-quality material make GTRACING chairs perfect for both home and modern offices.\n" +
                        "Upgrade your gaming office set-up with GTRACING.", "https://i5.walmartimages.com/asr/e4e2adf0-c675-4f04-8786-f592c3b10a62.dccf182c72638324783518f32afa8d7e.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF", "GTRACING", 139.99, user, Products.Categories.HOME),
                new Products("Torin Hydraulic Low Profile Trolley Service/Floor Jack", "Torin 2.5 Ton (5,000 lb) Capacity, Hydraulic Low Profile Trolley Service/Floor Jack with Single Piston Quick Lift Pump, Black, W8255-B", "https://i5.walmartimages.com/asr/a75f4652-2933-4f0f-a413-4a5cf0c5cefd.ae6f2644981f3bafbb2255bf6f52e2dc.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF", "Torin Jacks", 71.99, user, Products.Categories.AUTOMOTIVE),
                new Products("Dove Exfoliating Body Polish Scrub Macadamia & Rice Milk Body Scrub", "There’s one essential step for achieving smooth skin that shouldn’t be overlooked: exfoliation. So, gently buff away dry, dull skin while caring for your skin with Dove Macadamia and Rice Milk Exfoliating Body Polish. Made with ¼ moisturizing cream, this gentle exfoliating body scrub restores skin’s nutrients as it exfoliates, leaving your skin feeling silky smooth. With a smooth, easily spreadable texture, this Dove body exfoliator gives you beautifully creamy coverage while releasing a gently herbal " +
                        "and floral hypoallergenic fragrance. Get all the effectiveness you’d look for in exfoliators or a shower scrub, but with the nourishment and care that your skin needs in the shower. To use, scoop a generous amount of Dove Macadamia and Rice Milk Exfoliating Body Scrub out of the jar. Massage all over your body in circular motions for creamy coverage, and then rinse away to reveal silky smooth skin. Use 3-4 times per week as part of your skin care regimen, followed by Dove Body Wash or Beauty Bar for touchably soft skin. Try Dove Body Polish to get beach-ready skin, prep skin for tanning, or to help exfoliate " +
                        "before shaving to help prevent ingrown hairs. You'll love the feeling of silky smooth skin all over. Plus, when you buy Dove, you can be assured you’re caring for your skin with products that are PETA Cruelty-Free certified. Company-wide, we’re also on a mission to help the next generation of women develop a positive relationship with the way they look—reaching over ¼ of a billion young people with self-esteem education by 2030. We’re also committed to substantially reducing plastic waste by 2025. This includes reducing our use of virgin plastic by 20,500 metric tons annually, launching new 100% recycled " +
                        "plastic bottles and trialing new refillable formats for certain select products.", "https://i5.walmartimages.com/asr/72cd6b24-3c70-4387-80cd-09fb68e1de3c.4172db0c319d85648550a83a92367bed.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF", "Dove", 6.97, user, Products.Categories.BEAUTY)));
        userRepository.save(user);
        System.out.println(userRepository.findAll());
        productRepository.saveAll(productList);
        System.out.println(productRepository.findAll());
    }
}
