//進化画面の文字のちかちかするとこのコード
document.querySelector(`h1`).animate(
	[
		{ opacity: 1 },
		{ opacity: 0 }
	],
	{
		duration: 500,
		easing: 'linear',
		iterations: 6,
		direction: 'alternate'
	}
);


