<?php get_header(); ?>
<div id="postlist">
<div id="post-title-page">
<h1>Archive:<?php wp_title(''); ?> <?php if ( is_single() or is_page() or is_category() ) { ?> <?php } ?> </h1>
</div>

<ul class="cate">
		<?php if (have_posts()) : ?>
	
  		<?php while (have_posts()) : the_post(); ?>
	<li> <a href="<?php the_permalink() ?>" rel="bookmark"><?php the_title(); ?><br /><span>Date：<?php the_date(); ?>&nbsp;|&nbsp; Comment: <?php comments_number('0','1','%'); ?></span></a></li>
			
		<?php endwhile; else: ?>
			
		<div id="featured-post">
			<h2><a href="<?php the_permalink() ?>">Not Found</a></h2>
			<p>Sorry, but you are looking for something that isn't here.</p>
		</div>	
	
		<?php endif; ?>
        </ul>	
<div class="navigation clearfix">
		<div class="alignleft"><?php next_posts_link(__('&laquo; Older Entries')) ?></div>
			<div class="alignright"><?php previous_posts_link(__('Newer Entries &raquo;')) ?></div>
		</div>

	</div>


<?php get_sidebar(); ?>

<?php get_footer(); ?>