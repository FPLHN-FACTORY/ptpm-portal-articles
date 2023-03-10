package com.articlesprojectTool;

import com.articlesproject.entity.Album;
import com.articlesproject.entity.Articles;
import com.articlesproject.entity.Articles_Album;
import com.articlesproject.entity.Articles_Hashtag;
import com.articlesproject.entity.Category;
import com.articlesproject.entity.Comments;
import com.articlesproject.entity.Evaluate;
import com.articlesproject.entity.Hashtag;
import com.articlesproject.entity.Point;
import com.articlesproject.entity.Users;
import com.articlesproject.repository.AlbumRepository;
import com.articlesproject.repository.ArticlesRepository;
import com.articlesproject.repository.Articles_AlbumRepository;
import com.articlesproject.repository.Articles_HashtagRepository;
import com.articlesproject.repository.CategoryRepository;
import com.articlesproject.repository.CommentRepository;
import com.articlesproject.repository.EvalueteRepository;
import com.articlesproject.repository.HashtagRepository;
import com.articlesproject.repository.PointRepository;
import com.articlesproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(
        basePackages = "com.articlesproject.repository"
)
public class DBGenerator implements CommandLineRunner {


    private final boolean IS_RELEASE = false;
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private ArticlesRepository articlesRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private EvalueteRepository evalueteRepository;
    @Autowired
    private PointRepository pointRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Articles_AlbumRepository articles_albumRepository;

    @Autowired
    private Articles_HashtagRepository articles_hashtagRepository;

    @Autowired
    private HashtagRepository hashtagRepository;

    @Override
    public void run(String... args) throws Exception {
        Users users = new Users();
        users.setCode("PH27676");
        users.setName("Pham Xuan Hai");
        users.setEmail("xuanhai@fpt.edu.vn");
        users.setPhoneNumber("0343434343");
        users.setRole(0);
        users.setId(userRepository.save(users).getId());

        Users users1 = new Users();
        users1.setCode("PH99999");
        users1.setName("Duong Tut Thang");
        users1.setEmail("tutthang@fpt.edu.vn");
        users1.setPhoneNumber("099999999");
        users1.setRole(1);
        users.setId(userRepository.save(users1).getId());

        Category theLoai = new Category();
        theLoai.setCode("SOF1");
        theLoai.setName("Java");
        theLoai.setId(categoryRepository.save(theLoai).getId());

        Category theLoai1 = new Category();
        theLoai1.setCode("FE1");
        theLoai1.setName("Font-End");
        theLoai.setId(categoryRepository.save(theLoai1).getId());

        Hashtag hashtag = new Hashtag();
        hashtag.setTitle("#hahaha");
        hashtag.setId(hashtagRepository.save(hashtag).getId());

        Hashtag hashtag1 = new Hashtag();
        hashtag1.setTitle("#hiihii");
        hashtag1.setId(hashtagRepository.save(hashtag1).getId());

        Articles baiViet = new Articles();
        baiViet.setFileName("xuan-hai.html");
        baiViet.setTitle("Xin ch??o c??c b???n");
        baiViet.setContent("M??nh l?? Ph???m Xu??n H???i");
        baiViet.setStatus(1);
        baiViet.setCreateDate(1900800000L);
        baiViet.setBrowseDate(1900800000L);
        baiViet.setUsersId(users.getId());
        baiViet.setTym(10);
        baiViet.setId(articlesRepository.save(baiViet).getId());

        Articles baiViet1 = new Articles();
        baiViet1.setFileName("hoa-linh.html");
        baiViet1.setTitle("Xin ch??o c??c b???n");
        baiViet1.setContent("M??nh l?? Ph???m Xu??n hahaha");
        baiViet1.setStatus(1);
        baiViet1.setCreateDate(1900800000L);
        baiViet1.setBrowseDate(1900800000L);
        baiViet1.setUsersId(users.getId());
        baiViet1.setTym(10);
        baiViet1.setId(articlesRepository.save(baiViet1).getId());

        Articles baiViet2 = new Articles();
        baiViet2.setFileName("tut-thang.html");
        baiViet2.setTitle("Xin ch??o c??c b???n");
        baiViet2.setContent("M??nh l?? Ph???m Xu??n hihihih");
        baiViet2.setStatus(1);
        baiViet2.setCreateDate(1900800000L);
        baiViet2.setBrowseDate(1900800000L);
        baiViet2.setUsersId(users.getId());
        baiViet2.setTym(4);
        baiViet2.setId(articlesRepository.save(baiViet2).getId());

        Articles_Hashtag articles_hashtag = new Articles_Hashtag();
        articles_hashtag.setArticlesId(baiViet.getId());
        articles_hashtag.setHashtagId(hashtag.getId());
        articles_hashtag.setId(articles_hashtagRepository.save(articles_hashtag).getId());

        Comments comments = new Comments();
        comments.setContent("R???t bi???t ??n v??? nh???ng chia s??? th???c s??? b??? ??ch c???a b???n.\n" +
                "Mong b???n v?? gia ????nh nhi???u s???c kh???e, b??nh an.\n" +
                "HH");
        comments.setCreateAt(1900800000L);
        comments.setUsersId(users1.getId());
        comments.setArticlesId(baiViet.getId());
        comments.setId(commentRepository.save(comments).getId());

        Comments comments1 = new Comments();
        comments1.setContent("thank");
        comments1.setCreateAt(1900800000L);
        comments1.setUsersId(users.getId());
        comments1.setReply(comments.getId());
        comments1.setArticlesId(baiViet.getId());
        comments.setId(commentRepository.save(comments1).getId());

        Comments comments2 = new Comments();
        comments2.setContent("Anh Th???nh ??i, hi???n t???i team em ??ang c???n l??m slide li??n quan t???i value c???a BA, c?? m???t s??? ph???n c???n h??nh ???nh minh ho???. Kh??ng bi???t m???y h??nh sketch anh d??ng l??m ???nh thumbnail cho b??i vi???t th?? anh v??? ??? ????u ???? Ho???c n???u ???????c ko bi???t em c?? th??? xin h??nh ???nh c???a blog m??nh ???????c ko ???? Em c???m ??n anh nhi???u ???.");
        comments2.setCreateAt(1900800000L);
        comments2.setUsersId(users1.getId());
        comments2.setArticlesId(baiViet1.getId());
        comments.setId(commentRepository.save(comments2).getId());

        Comments comments3 = new Comments();
        comments3.setContent("?? h??nh ???? anh t??? v??? ??, em c??? l???y tho???i m??i nh??, nh??ng nh??? ghi ngu???n thinhnotes.com v??o gi??p anh nha");
        comments3.setCreateAt(1900800000L);
        comments3.setUsersId(users.getId());
        comments3.setReply(comments2.getId());
        comments3.setArticlesId(baiViet1.getId());
        comments.setId(commentRepository.save(comments3).getId());

        Comments comments4 = new Comments();
        comments4.setContent("Em ch??o anh, b??i vi???t c???a anh r???t b??? ??ch. Em mu???n h???i th??m 1 ch??t x??u v??? User Req trong FS ???.\n" +
                "Theo nh?? trong b??i th?? ph???n n??y s??? focus v??o Business & Stakeholder Reqs m?? theo em ???????c hi???u th?? Stakeholder Req n?? l?? requirement chi ti???t h??n c???a Business Req.\n" +
                "V???y th?? trong FS m??nh c???n mention c??? 2 lo???i n??y 1 c??ch ?????c l???p hay sao anh nh????");
        comments4.setCreateAt(1900800000L);
        comments4.setUsersId(users.getId());
        comments4.setReply(comments.getId());
        comments4.setArticlesId(baiViet2.getId());
        comments.setId(commentRepository.save(comments4).getId());


        Album album = new Album();
        album.setTitle("Java");
        album.setUsersId(users1.getId());
        album.setId(albumRepository.save(album).getId());

        Album album1 = new Album();
        album1.setTitle("Java");
        album1.setUsersId(users1.getId());
        album.setId(albumRepository.save(album1).getId());

        Album album2 = new Album();
        album2.setUsersId(users.getId());
        album.setId(albumRepository.save(album2).getId());

        Articles_Album baiVietAlbum = new Articles_Album();
        baiVietAlbum.setAlbumId(album.getId());
        baiVietAlbum.setArticlesId(baiViet.getId());
        baiVietAlbum.setId(articles_albumRepository.save(baiVietAlbum).getId());

        Point diem = new Point();
        diem.setPoint(9);
        diem.setCreateAt(1900800000L);
        diem.setFeedback("");
        diem.setArticlesId(baiViet.getId());
        diem.setUsersId(users.getId());
        diem.setId(pointRepository.save(diem).getId());

        Point diem1 = new Point();
        diem1.setPoint(9);
        diem1.setCreateAt(1900800000L);
        diem1.setFeedback("");
        diem1.setArticlesId(baiViet.getId());
        diem1.setUsersId(users.getId());
        diem1.setId(pointRepository.save(diem1).getId());

        Point diem2 = new Point();
        diem2.setPoint(9);
        diem2.setCreateAt(1900800000L);
        diem2.setFeedback("");
        diem2.setArticlesId(baiViet.getId());
        diem2.setUsersId(users.getId());
        diem.setId(pointRepository.save(diem2).getId());

        Point diem3 = new Point();
        diem3.setPoint(9);
        diem3.setCreateAt(1900800000L);
        diem3.setFeedback("");
        diem3.setArticlesId(baiViet.getId());
        diem3.setUsersId(users.getId());
        diem3.setId(pointRepository.save(diem3).getId());

        Evaluate danhGia = new Evaluate();
        danhGia.setStar(2);
        danhGia.setCreateAt(1900800000L);
        danhGia.setContent("Bug");
        danhGia.setUsersId(users.getId());
        danhGia.setArticlesId(baiViet1.getId());
        danhGia.setId(evalueteRepository.save(danhGia).getId());

        Evaluate danhGia1 = new Evaluate();
        danhGia1.setStar(2);
        danhGia1.setCreateAt(1900800000L);
        danhGia1.setContent("Bug");
        danhGia1.setUsersId(users.getId());
        danhGia1.setArticlesId(baiViet1.getId());
        danhGia1.setId(evalueteRepository.save(danhGia1).getId());


        Evaluate danhGia2 = new Evaluate();
        danhGia2.setStar(2);
        danhGia2.setCreateAt(1900800000L);
        danhGia2.setContent("Bug");
        danhGia2.setUsersId(users.getId());
        danhGia2.setArticlesId(baiViet1.getId());
        danhGia2.setId(evalueteRepository.save(danhGia2).getId());

    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DBGenerator.class);
        ctx.close();
    }

}
